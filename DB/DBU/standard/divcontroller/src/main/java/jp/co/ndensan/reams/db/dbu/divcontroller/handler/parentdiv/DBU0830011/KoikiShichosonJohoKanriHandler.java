/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0830011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonMasterBuilder;
import jp.co.ndensan.reams.db.dbe.business.core.basic.KoseiShichosonMasterIdentifier;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.KoikiShichosonJohoKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.dgKoikiShichosonSelect_Row;
import jp.co.ndensan.reams.db.dbu.service.core.koikishichosonjohokanri.KoikiShichosonJohoKanriManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NofugakuDataRenkeiHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.RozinhokenbangotaikeiCheck;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaiyusenChikuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShotokuHikidashiHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.TokuchoBunpaiShuyaku;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu.GaikokujinShimeiHyojihoho;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 広域システム管理のHandlerクラスです。
 *
 * @reamsid_L DBU-4010-010 duanzhanli
 */
public class KoikiShichosonJohoKanriHandler {

    private final KoikiShichosonJohoKanriDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 広域システム管理Div
     */
    public KoikiShichosonJohoKanriHandler(KoikiShichosonJohoKanriDiv div) {
        this.div = div;
    }

    /**
     * 広域市町村一覧Gridの設定。
     */
    public void onLoad() {
        List<KoseiShichosonMaster> masterList = KoikiShichosonJohoKanriManager.createInstance().get広域市町村一覧().records();
        List<dgKoikiShichosonSelect_Row> rowList = new ArrayList<>();
        for (KoseiShichosonMaster master : masterList) {
            dgKoikiShichosonSelect_Row row = new dgKoikiShichosonSelect_Row();
            row.setKoikiNaiNo(getRstring(master.get市町村識別ID()));
            row.setHokenjaNo(master.get証記載保険者番号() == null ? RString.EMPTY : master.get証記載保険者番号().value());
            row.setShichosonName(getRstring(master.get市町村名称()));
            row.setShichosonCode(master.get市町村コード() == null ? RString.EMPTY : master.get市町村コード().value());
            row.setRojinHokenShichosonNo(getRstring(master.get老人保健市町村番号()));
            row.setKanyuYMD(get和暦(master.get加入日()));
            row.setDattaiYMD(get和暦(master.get離脱日()));
            rowList.add(row);
        }
        div.getKoikiShichosonSelect().getDgKoikiShichosonSelect().setDataSource(rowList);
    }

    /**
     * 編集内容か表示され、編集ができる。
     *
     */
    public void 適用情報の編集() {
        dgKoikiShichosonSelect_Row row = div.getKoikiShichosonSelect().getDgKoikiShichosonSelect().getActiveRow();
        div.getKoikiShichosonJohoMaintenance().getDdlGaikokujinShimei().setDataSource(getDdlGaikokujinShimei());
        div.getKoikiShichosonJohoMaintenance().getDdlShotokuHikidashiHoho().setDataSource(getDdlShotokuHikidashiHoho());
        div.getKoikiShichosonJohoMaintenance().getDdlSaiyusenChikuCode().setDataSource(getDdlSaiyusenChikuCode());
        div.getKoikiShichosonJohoMaintenance().getDdlTokuchoBunpai().setDataSource(getDdlTokuchoBunpai());
        div.getKoikiShichosonJohoMaintenance().getDdlRojinHokenJukyushaNoTaikei().setDataSource(getDdlRojinHokenJukyushaNoTaikei());
        div.getKoikiShichosonJohoMaintenance().getDdlNofugakuDataRenkei().setDataSource(getDdlNofugakuDataRenkei());

        KoseiShichosonMaster master = KoikiShichosonJohoKanriManager.createInstance().getメンテナンス情報(row.getKoikiNaiNo()).records().get(0);
        ViewStateHolder.put(ViewStateKeys.広域内市町村情報, Models.create(KoikiShichosonJohoKanriManager.
                createInstance().getメンテナンス情報(row.getKoikiNaiNo()).records()));
        div.getKoikiShichosonJohoMaintenance().getTxtShichonoShikibetsuID().setValue(row.getKoikiNaiNo());
        div.getKoikiShichosonJohoMaintenance().getTxtShokisaiHokenshaNo().setValue(master.get証記載保険者番号() == null
                ? RString.EMPTY : master.get証記載保険者番号().value());
        div.getKoikiShichosonJohoMaintenance().getTxtKokuhorenShichosonNo().setValue(master.get国保連広域内市町村番号());
        div.getKoikiShichosonJohoMaintenance().getTxtShichosonCode().setValue(master.get市町村コード() == null
                ? RString.EMPTY : master.get市町村コード().value());
        div.getKoikiShichosonJohoMaintenance().getTxtTodofukenName().setValue(master.get都道府県名称());
        div.getKoikiShichosonJohoMaintenance().getTxtGunName().setValue(master.get郡名称());
        div.getKoikiShichosonJohoMaintenance().getTxtJusho().setDomain(master.get住所());
        div.getKoikiShichosonJohoMaintenance().getTxtShichosonName().setValue(master.get市町村名称());
        div.getKoikiShichosonJohoMaintenance().getTxtYubinNo().setValue(master.get郵便番号());
        div.getKoikiShichosonJohoMaintenance().getTxtKanyuYMD().setValue(master.get加入日());
        div.getKoikiShichosonJohoMaintenance().getTxtTelNo().setDomain(master.get電話番号());
        div.getKoikiShichosonJohoMaintenance().getTxtRojinHokenShichosonNo().setValue(master.get老人保健市町村番号());
        div.getKoikiShichosonJohoMaintenance().getTxtDattaiYMD().setValue(master.get離脱日());

        div.getKoikiShichosonJohoMaintenance().getDdlGaikokujinShimei().setSelectedKey(master.get外国人氏名表示方法());
        div.getKoikiShichosonJohoMaintenance().getDdlShotokuHikidashiHoho().setSelectedKey(master.get所得引出方法());
        div.getKoikiShichosonJohoMaintenance().getDdlSaiyusenChikuCode().setSelectedKey(master.get最優先地区コード());
        div.getKoikiShichosonJohoMaintenance().getDdlTokuchoBunpai().setSelectedKey(master.get特徴分配集約());
        div.getKoikiShichosonJohoMaintenance().getDdlRojinHokenJukyushaNoTaikei().setSelectedKey(master.get老人保健受給者番号体系());
        div.getKoikiShichosonJohoMaintenance().getDdlNofugakuDataRenkei().setSelectedKey(master.get納付額データ連携方法());
        //TODO 共有子Div「帳票住所デフォルト表記方法」が未実装
    }

    /**
     * 編集内容か表示され、編集ができる。
     *
     */
    public void update市町村管理() {
        Models<KoseiShichosonMasterIdentifier, KoseiShichosonMaster> 修正前市町村Models
                = ViewStateHolder.get(ViewStateKeys.広域内市町村情報, Models.class);
        KoseiShichosonMaster 修正前市町村 = 修正前市町村Models.get(new KoseiShichosonMasterIdentifier(
                div.getTxtShichonoShikibetsuID().getValue()));
        KoseiShichosonMasterBuilder 市町村管理Builder = 修正前市町村.createBuilderForEdit();
        市町村管理Builder.set国保連広域内市町村番号(div.getTxtKokuhorenShichosonNo().getValue());
        市町村管理Builder.set都道府県名称(div.getTxtTodofukenName().getValue());
        市町村管理Builder.set市町村名称(div.getTxtShichosonName().getValue());
        市町村管理Builder.set郵便番号(div.getTxtYubinNo().getValue());
        市町村管理Builder.set外国人氏名表示方法(div.getDdlGaikokujinShimei().getSelectedKey());
        市町村管理Builder.set最優先地区コード(div.getDdlSaiyusenChikuCode().getSelectedKey());
        市町村管理Builder.set加入日(div.getTxtKanyuYMD().getValue());
        市町村管理Builder.set所得引出方法(div.getDdlShotokuHikidashiHoho().getSelectedKey());
        市町村管理Builder.set特徴分配集約(div.getDdlTokuchoBunpai().getSelectedKey());
        市町村管理Builder.set証記載保険者番号(new ShoKisaiHokenshaNo(div.getTxtShokisaiHokenshaNo().getValue()));
        市町村管理Builder.set郡名称(div.getTxtGunName().getValue());
        市町村管理Builder.set住所(div.getTxtJusho().getDomain());
        市町村管理Builder.set電話番号(div.getTxtTelNo().getDomain());
        市町村管理Builder.set老人保健市町村番号(div.getTxtRojinHokenShichosonNo().getValue());
        市町村管理Builder.set老人保健受給者番号体系(div.getDdlRojinHokenJukyushaNoTaikei().getSelectedKey());
        市町村管理Builder.set離脱日(div.getTxtDattaiYMD().getValue());
        市町村管理Builder.set納付額データ連携方法(div.getDdlNofugakuDataRenkei().getSelectedKey());
        KoikiShichosonJohoKanriManager.createInstance().save市町村Master(市町村管理Builder.build());
    }

    private List<KeyValueDataSource> getDdlNofugakuDataRenkei() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (NofugakuDataRenkeiHoho enumData : NofugakuDataRenkeiHoho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(enumData.getコード());
            dataSource.setValue(enumData.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> getDdlRojinHokenJukyushaNoTaikei() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (RozinhokenbangotaikeiCheck enumData : RozinhokenbangotaikeiCheck.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(enumData.getコード());
            dataSource.setValue(enumData.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> getDdlTokuchoBunpai() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (TokuchoBunpaiShuyaku enumData : TokuchoBunpaiShuyaku.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(enumData.getコード());
            dataSource.setValue(enumData.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> getDdlSaiyusenChikuCode() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (SaiyusenChikuCode enumData : SaiyusenChikuCode.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(enumData.getコード());
            dataSource.setValue(enumData.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> getDdlShotokuHikidashiHoho() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (ShotokuHikidashiHoho enumData : ShotokuHikidashiHoho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(enumData.getコード());
            dataSource.setValue(enumData.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private List<KeyValueDataSource> getDdlGaikokujinShimei() {
        List<KeyValueDataSource> dataSourceList = new ArrayList<>();
        for (GaikokujinShimeiHyojihoho enumData : GaikokujinShimeiHyojihoho.values()) {
            KeyValueDataSource dataSource = new KeyValueDataSource();
            dataSource.setKey(enumData.getコード());
            dataSource.setValue(enumData.get名称());
            dataSourceList.add(dataSource);
        }
        return dataSourceList;
    }

    private RString getRstring(RString value) {
        RString 戻り値 = RString.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = value;
        }
        return 戻り値;
    }

    private RString get和暦(FlexibleDate value) {
        RString 戻り値 = RString.EMPTY;
        if (value != null) {
            戻り値 = value.wareki().eraType(EraType.KANJI_RYAKU).toDateString();
        }
        return 戻り値;
    }
}
