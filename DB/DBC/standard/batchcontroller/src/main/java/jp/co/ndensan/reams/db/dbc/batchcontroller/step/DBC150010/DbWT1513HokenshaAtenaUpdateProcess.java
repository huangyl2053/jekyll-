/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.dbc150010.AtenaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.DbWT1513RiyoJokyoTokeihyoEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.riyojokyotokeihyomeisailistsakusei.HihokenshaAtenaJohoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.riyojokyotokeihyomeisailistsakusei.RiyoJokyoTokeihyoMeisaiListSakuseiService;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbz.service.core.chohyojushoeditor.ChohyoJushoEditor;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者・宛名更新のプロセスです。
 *
 * @reamsid_L DBC-3500-030 zuotao
 */
public class DbWT1513HokenshaAtenaUpdateProcess extends BatchProcessBase<HihokenshaAtenaJohoEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper."
            + "relate.riyojokyotokeihyomeisailistsakusei.IRiyoJokyoTokeihyoMeisaiListSakuseiMapper.select被保険者宛名情報");

    private static final RString TABLE_利用状況統計表一時 = new RString("DbWT1513RiyoJokyoTokeihyo");
    @BatchWriter
    BatchEntityCreatedTempTableWriter 利用状況統計表一時TBL;
    RiyoJokyoTokeihyoMeisaiListSakuseiService service;
    ChohyoJushoEditor 帳票住所編集クラス;

    @Override
    protected IBatchReader createReader() {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> juminShubetsuList = new ArrayList<>();
        juminShubetsuList.add(JuminShubetsu.日本人);
        juminShubetsuList.add(JuminShubetsu.外国人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_日本人);
        juminShubetsuList.add(JuminShubetsu.住登外個人_外国人);
        key.set住民種別(juminShubetsuList);
        List<JuminJotai> juminJotaiList = new ArrayList<>();
        juminJotaiList.add(JuminJotai.住民);
        juminJotaiList.add(JuminJotai.住登外);
        juminJotaiList.add(JuminJotai.消除者);
        juminJotaiList.add(JuminJotai.転出者);
        juminJotaiList.add(JuminJotai.死亡者);
        key.set住民状態(juminJotaiList);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString psmShikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());
        AtenaJohoMybatisParameter parameter = new AtenaJohoMybatisParameter();
        parameter.setPsmShikibetsuTaisho(psmShikibetsuTaisho);
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter);
    }

    @Override
    protected void createWriter() {
        帳票住所編集クラス = new ChohyoJushoEditor(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC200004.getReportId().value(), GyomuBunrui.介護事務);
        service = RiyoJokyoTokeihyoMeisaiListSakuseiService.createInstance();
        利用状況統計表一時TBL = new BatchEntityCreatedTempTableWriter(TABLE_利用状況統計表一時,
                DbWT1513RiyoJokyoTokeihyoEntity.class);
    }

    @Override
    protected void process(HihokenshaAtenaJohoEntity entity) {
        利用状況統計表一時TBL.update(service.create被保険者台帳宛名情報(entity, 帳票住所編集クラス));
    }
}
