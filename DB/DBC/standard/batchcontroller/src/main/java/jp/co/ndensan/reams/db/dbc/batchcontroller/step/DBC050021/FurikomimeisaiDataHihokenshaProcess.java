/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC050021;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc050010.HihokenshaAtenaMybatisParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.dbc050021.HihokenshaToAtenaResultEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiranjigyokogaku.DbWT0510FurikomiMeisaiTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor.ChohyoJushoEditor;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.IShikibetsuTaisho;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.ShikibetsuTaishoFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DoitsuninDaihyoshaYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.shikibetsutaisho.IShikibetsuTaishoPSMSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * 被保険者台帳・宛名情報の取得_Process処理クラスです。
 *
 * @reamsid_L DBC-4870-030 gongliang
 */
public class FurikomimeisaiDataHihokenshaProcess extends BatchProcessBase<HihokenshaToAtenaResultEntity> {

    private static final RString 帳票分類ID = new RString("DBC200003_FurikomiMeisaiIchiran");
    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc050021."
            + "IFurikomimeisaiFurikomiDataMapper.get被保険者台帳と宛名情報");
    private static final RString 振込明細一時NAME = new RString("DbWT0510FurikomiMeisai");
    private static final RString RSTRING_1 = new RString("1");

    @BatchWriter
    BatchEntityCreatedTempTableWriter 振込明細一時tableWriter;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoPSMSearchKeyBuilder key = new ShikibetsuTaishoPSMSearchKeyBuilder(
                GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先);
        List<JuminShubetsu> 住民種別List = new ArrayList<>();
        List<JuminJotai> 住民状態List = new ArrayList<>();
        key.set住民種別(get住民種別(住民種別List));
        key.set住民状態(get住民状態(住民状態List));
        key.set同一人代表者優先区分(DoitsuninDaihyoshaYusenKubun.同一人代表者を優先しない);
        IShikibetsuTaishoPSMSearchKey shikibetsuTaishoPSMSearchKey = key.build();
        return new BatchDbReader(MYBATIS_SELECT_ID, new HihokenshaAtenaMybatisParameter(shikibetsuTaishoPSMSearchKey));
    }

    @Override
    protected void createWriter() {
        振込明細一時tableWriter = new BatchEntityCreatedTempTableWriter(振込明細一時NAME, DbWT0510FurikomiMeisaiTempEntity.class);
    }

    @Override
    protected void process(HihokenshaToAtenaResultEntity entity) {
        DbWT0510FurikomiMeisaiTempEntity 振込明細一時Entity = entity.get振込明細一時Entity();
        DbT1001HihokenshaDaichoEntity 被保険者台帳 = entity.get被保険者台帳();
        IShikibetsuTaisho 識別対象 = ShikibetsuTaishoFactory.createKojin(entity.get宛名Entity());
        ChohyoJushoEditor 住所Editor = new ChohyoJushoEditor(SubGyomuCode.DBC介護給付, 帳票分類ID, GyomuBunrui.介護事務);
        RString 管内管外区分 = 識別対象.get住所().get管内管外().toRString();
        RString 住所 = 識別対象.get住所().get住所();
        RString 番地 = 識別対象.get住所().get番地().getBanchi().getColumnValue();
        RString 方書 = 識別対象.get住所().get方書().getColumnValue();
        RString 行政区名 = 識別対象.get行政区画().getGyoseiku().get名称();
        LasdecCode 市町村コード;
        if (RSTRING_1.equals(被保険者台帳.getKoikinaiJushochiTokureiFlag())) {
            市町村コード = 被保険者台帳.getKoikinaiTokureiSochimotoShichosonCode();
        } else {
            市町村コード = 被保険者台帳.getShichosonCode();
        }
        RString 編集住所 = 住所Editor.editJusho(管内管外区分, 住所, 番地, 方書, 行政区名, 市町村コード);

        振込明細一時Entity.setShikibetsuCode(識別対象.get識別コード());
        振込明細一時Entity.setShimeiKana(識別対象.get名称().getKana());
        振込明細一時Entity.setShimei(識別対象.get名称().getName());
        振込明細一時Entity.setShimei50onKana(RStringUtil.convertTo清音化(識別対象.get名称().getKana().getColumnValue()));
        振込明細一時Entity.setChoikiCode(識別対象.get住所().get町域コード());
        振込明細一時Entity.setGyoseikuCode(識別対象.get行政区画().getGyoseiku().getコード());
        振込明細一時Entity.setGyoseikuMei(識別対象.get行政区画().getGyoseiku().get名称());
        振込明細一時Entity.setYubinNo(識別対象.get住所().get郵便番号());
        振込明細一時Entity.setJusho(new AtenaJusho(編集住所));
        振込明細一時Entity.setShichosonCode(市町村コード);
        振込明細一時tableWriter.update(振込明細一時Entity);

    }

    private List<JuminShubetsu> get住民種別(List<JuminShubetsu> 住民種別List) {
        住民種別List.add(JuminShubetsu.日本人);
        住民種別List.add(JuminShubetsu.外国人);
        住民種別List.add(JuminShubetsu.住登外個人_日本人);
        住民種別List.add(JuminShubetsu.住登外個人_外国人);
        return 住民種別List;
    }

    private List<JuminJotai> get住民状態(List<JuminJotai> 住民状態List) {
        住民状態List.add(JuminJotai.住民);
        住民状態List.add(JuminJotai.住登外);
        住民状態List.add(JuminJotai.消除者);
        住民状態List.add(JuminJotai.転出者);
        住民状態List.add(JuminJotai.死亡者);
        return 住民状態List;
    }

}
