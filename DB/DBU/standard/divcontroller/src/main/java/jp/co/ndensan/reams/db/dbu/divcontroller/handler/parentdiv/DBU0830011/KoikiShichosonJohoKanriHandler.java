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
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.KoikiShichosonJohoKanriDiv;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0830011.dgKoikiShichosonSelect_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.GaikokujinShimeiHyojihoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NofugakuDataRenkeiHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.RozinhokenbangotaikeiCheck;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.SaiyusenChikuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShotokuHikidashiHoho;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.TokuchoBunpaiShuyaku;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

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
     *
     * @param masterList masterList
     */
    public void onLoad(List<KoseiShichosonMaster> masterList) {
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
     * @param master master
     * @param row row
     */
    public void 適用情報の編集(dgKoikiShichosonSelect_Row row, KoseiShichosonMaster master) {
        div.getKoikiShichosonJohoMaintenance().getDdlGaikokujinShimei().setDataSource(getDdlGaikokujinShimei());
        div.getKoikiShichosonJohoMaintenance().getDdlShotokuHikidashiHoho().setDataSource(getDdlShotokuHikidashiHoho());
        div.getKoikiShichosonJohoMaintenance().getDdlSaiyusenChikuCode().setDataSource(getDdlSaiyusenChikuCode());
        div.getKoikiShichosonJohoMaintenance().getDdlTokuchoBunpai().setDataSource(getDdlTokuchoBunpai());
        div.getKoikiShichosonJohoMaintenance().getDdlRojinHokenJukyushaNoTaikei().setDataSource(getDdlRojinHokenJukyushaNoTaikei());
        div.getKoikiShichosonJohoMaintenance().getDdlNofugakuDataRenkei().setDataSource(getDdlNofugakuDataRenkei());

        div.getKoikiShichosonJohoMaintenance().getTxtShichonoShikibetsuID().setValue(row.getKoikiNaiNo());
        div.getKoikiShichosonJohoMaintenance().getTxtShokisaiHokenshaNo().setValue(master.get証記載保険者番号() == null
                ? RString.EMPTY : master.get証記載保険者番号().value());
        div.getKoikiShichosonJohoMaintenance().getTxtKokuhorenShichosonNo().setValue(nullToEmpty(master.get国保連広域内市町村番号()));
        div.getKoikiShichosonJohoMaintenance().getTxtShichosonCode().setValue(master.get市町村コード() == null
                ? RString.EMPTY : master.get市町村コード().value());
        div.getKoikiShichosonJohoMaintenance().getTxtTodofukenName().setValue(nullToEmpty(master.get都道府県名称()));
        div.getKoikiShichosonJohoMaintenance().getTxtGunName().setValue(nullToEmpty(master.get郡名称()));
        AtenaJusho 住所 = master.get住所();
        if (住所 != null) {
            div.getKoikiShichosonJohoMaintenance().getTxtJusho().setDomain(住所);
        }
        div.getKoikiShichosonJohoMaintenance().getTxtShichosonName().setValue(nullToEmpty(master.get市町村名称()));
        YubinNo 郵便番号 = master.get郵便番号();
        if (郵便番号 != null) {
            div.getKoikiShichosonJohoMaintenance().getTxtYubinNo().setValue(郵便番号);
        }
        div.getKoikiShichosonJohoMaintenance().getTxtKanyuYMD().setValue(master.get加入日());
        TelNo 電話番号 = master.get電話番号();
        if (電話番号 != null) {
            div.getKoikiShichosonJohoMaintenance().getTxtTelNo().setDomain(電話番号);
        }
        div.getKoikiShichosonJohoMaintenance().getTxtRojinHokenShichosonNo().setValue(master.get老人保健市町村番号());
        FlexibleDate 離脱日 = master.get離脱日();
        if (離脱日 != null) {
            div.getKoikiShichosonJohoMaintenance().getTxtDattaiYMD().setValue(離脱日);
        }
        div.getKoikiShichosonJohoMaintenance().getDdlGaikokujinShimei().setSelectedKey(master.get外国人氏名表示方法());
        div.getKoikiShichosonJohoMaintenance().getDdlShotokuHikidashiHoho().setSelectedKey(master.get所得引出方法());
        div.getKoikiShichosonJohoMaintenance().getDdlSaiyusenChikuCode().setSelectedKey(master.get最優先地区コード());
        div.getKoikiShichosonJohoMaintenance().getDdlTokuchoBunpai().setSelectedKey(master.get特徴分配集約());
        div.getKoikiShichosonJohoMaintenance().getDdlRojinHokenJukyushaNoTaikei().setSelectedKey(master.get老人保健受給者番号体系());
        div.getKoikiShichosonJohoMaintenance().getDdlNofugakuDataRenkei().setSelectedKey(master.get納付額データ連携方法());
        div.setHiddenInputDiv(getInputDiv());
        //TODO 共有子Div「帳票住所デフォルト表記方法」が未実装
    }

    private RString nullToEmpty(RString value) {
        RString 戻り値 = RString.EMPTY;
        if (!RString.isNullOrEmpty(value)) {
            戻り値 = value;
        }
        return 戻り値;
    }

    /**
     * 編集内容をRStringに保存します。
     *
     * @return 編集結果
     */
    public RString getInputDiv() {
        RStringBuilder inputDiv = new RStringBuilder();
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtShichonoShikibetsuID().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtShokisaiHokenshaNo().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtKokuhorenShichosonNo().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtShichosonCode().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtTodofukenName().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtGunName().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtJusho().getDomain().value());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtShichosonName().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtYubinNo().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtKanyuYMD().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtTelNo().getDomain().value());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtRojinHokenShichosonNo().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getTxtDattaiYMD().getValue());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getDdlGaikokujinShimei().getSelectedKey());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getDdlShotokuHikidashiHoho().getSelectedKey());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getDdlSaiyusenChikuCode().getSelectedKey());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getDdlTokuchoBunpai().getSelectedKey());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getDdlRojinHokenJukyushaNoTaikei().getSelectedKey());
        inputDiv.append(div.getKoikiShichosonJohoMaintenance().getDdlNofugakuDataRenkei().getSelectedKey());
        return inputDiv.toRString();
    }

    /**
     * 編集内容か表示され、編集ができる。
     *
     * @param 市町村管理Builder 市町村管理Builder
     * @return KoseiShichosonMaster KoseiShichosonMaster
     */
    public KoseiShichosonMaster get市町村管理情報(KoseiShichosonMasterBuilder 市町村管理Builder) {
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
        return 市町村管理Builder.build();
    }

    /**
     * 加入日と脱退日の期間をチェックします。
     *
     * @return 重複チェックフラグ
     */
    public boolean is期間チェックフラグ() {
        FlexibleDate 加入日 = get加入日();
        FlexibleDate 脱退日 = get脱退日();
        if (加入日 != null && !加入日.isEmpty() && 脱退日 != null && !脱退日.isEmpty()) {
            return 脱退日.isBefore(加入日);
        }
        return false;
    }

    /**
     * 加入日を取得します。
     *
     * @return 重複チェックフラグ
     */
    public FlexibleDate get加入日() {
        return div.getTxtKanyuYMD().getValue();
    }

    /**
     * 脱退日を取得します。
     *
     * @return 重複チェックフラグ
     */
    public FlexibleDate get脱退日() {
        return div.getTxtDattaiYMD().getValue();
    }

    /**
     * 画面内容変更をチェックします。
     *
     * @return 判定結果(true:変更あり,false:変更なし)
     */
    public boolean isUpdate() {
        return getInputDiv().equals(div.getHiddenInputDiv());
    }

    /**
     * 市町村識別IDを取得します。
     *
     * @return 市町村識別ID
     */
    public RString get市町村識別ID() {
        return div.getTxtShichonoShikibetsuID().getValue();
    }

    /**
     * 適用情報一覧該当行を取得します。
     *
     * @return dgKoikiShichosonSelect_Row
     */
    public dgKoikiShichosonSelect_Row get適用情報一覧該当行() {
        return div.getKoikiShichosonSelect().getDgKoikiShichosonSelect().getActiveRow();
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
