/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010013;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio.KaigoJogaiTokureiBusiness;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.JigyoshaToutokuDiv;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010013.dgServiceList_Row;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyosha.KaigoJigyosha;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * 事業者登録Handlerクラスです。
 * 
 * @reamsid_L DBA-0340-050  lijia
 *
 */
public class JigyoshaTourokuHandler {

    private final JigyoshaToutokuDiv panelDiv;
    private static final RString 状態_追加 = new RString("追加");
    private static final RString 状態_更新 = new RString("更新");
    private static final RString 状態_削除 = new RString("削除");
    private static final RString 状態_照会 = new RString("照会");
    private static final RString 法人等種別 = new RString("12");
    private static final RString 基準該当等事業所区分 = new RString("3");

    /**
     * コンストラクタです。
     *
     * @param panelDiv 事業者登録Div
     */
    public JigyoshaTourokuHandler(JigyoshaToutokuDiv panelDiv) {
        this.panelDiv = panelDiv;
    }

    /**
     * 画面初期化処理します。
     *
     * @param viewState 表示状態
     */
    public void initialize(RString viewState) {
        if (viewState.equals(状態_追加)) {
            get画面初期の追加モードの表示制御();

        } else if (viewState.equals(状態_更新)) {
            get画面初期の更新モードの表示制御();

        } else if (viewState.equals(状態_削除)) {
            get画面初期の削除モードの表示制御();

        } else if (viewState.equals(状態_照会)) {
            get画面初期の照会モードの表示制御();

        }
    }

    private void get画面初期の追加モードの表示制御() {
        panelDiv.getJigyoshaShurui().setDisabled(false);
        panelDiv.getServiceJigyoshaJoho().setDisabled(false);
        panelDiv.getDaihyoshaJoho().setDisabled(false);
        panelDiv.getKaisetsushaJoho().setDisabled(false);
        panelDiv.getServiceJoho().setDisabled(false);
    }

    private void get画面初期の更新モードの表示制御() {
        panelDiv.getJigyoshaShurui().setDisabled(true);
        panelDiv.getServiceJigyoshaJoho().setDisabled(false);
        panelDiv.getDaihyoshaJoho().setDisabled(false);
        panelDiv.getKaisetsushaJoho().setDisabled(false);
        panelDiv.getServiceJoho().setDisabled(false);
    }

    private void get画面初期の削除モードの表示制御() {
        panelDiv.getJigyoshaShurui().setDisabled(true);
        panelDiv.getServiceJigyoshaJoho().setDisabled(true);
        panelDiv.getDaihyoshaJoho().setDisabled(true);
        panelDiv.getKaisetsushaJoho().setDisabled(true);
        panelDiv.getServiceJoho().setDisabled(true);
    }

    private void get画面初期の照会モードの表示制御() {
        panelDiv.getJigyoshaShurui().setDisabled(true);
        panelDiv.getServiceJigyoshaJoho().setDisabled(true);
        panelDiv.getDaihyoshaJoho().setDisabled(true);
        panelDiv.getKaisetsushaJoho().setDisabled(true);
        panelDiv.getServiceJoho().setDisabled(true);
    }

    /**
     * 画面の事業者情報、代表者情報、開設者情報を設定します。
     *
     * @param selectFlag 検索結果あり/なし
     * @param business 介護事業者・施設管理のBusiness
     */
    public void get事業者情報_代表者_開設者情報(boolean selectFlag, KaigoJigyosha business) {
        if (selectFlag) {
            get事業者情報_代表者_開設者あり場合(business);
            get事業者情報_代表者_開設者あり場合2(business);
        } else {
            get事業者情報_代表者_開設者の情報できないの場合();
        }
    }

    private void get事業者情報_代表者_開設者あり場合(KaigoJigyosha business) {
        panelDiv.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().setValue(business.get有効開始日());
        panelDiv.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().setValue(
                business.get有効終了日() == null ? FlexibleDate.EMPTY : business.get有効終了日());
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoshaNo().setValue(business.get事業者番号().getColumnValue());
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoshaName().setValue(business.get事業者名称().getColumnValue());
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoshaNameKana().setValue(business.get事業者名称カナ().getColumnValue());
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoKaishiYMD().setValue(
                business.get事業開始日() == null ? FlexibleDate.EMPTY : business.get事業開始日());
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoKyushuYMD().setValue(
                business.get事業休止日() == null ? FlexibleDate.EMPTY : business.get事業休止日());
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoSaikaiYMD().setValue(
                business.get事業再開日() == null ? FlexibleDate.EMPTY : business.get事業再開日());
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoHaishiYMD().setValue(
                business.get事業廃止日() == null ? FlexibleDate.EMPTY : business.get事業廃止日());
        panelDiv.getServiceJigyoshaJoho().getTxtYubinNo().setValue(
                business.get郵便番号() == null ? YubinNo.EMPTY : business.get郵便番号());
        TelNo 電話番号 = business.get電話番号();
        panelDiv.getServiceJigyoshaJoho().getTxtTelNo().setValue(電話番号 == null ? RString.EMPTY : 電話番号.getColumnValue());
        TelNo fax番号 = business.getFAX番号();
        panelDiv.getServiceJigyoshaJoho().getTxtFaxNo().setValue(fax番号 == null ? RString.EMPTY : fax番号.getColumnValue());
        AtenaJusho 事業者住所 = business.get事業者住所();
        panelDiv.getServiceJigyoshaJoho().getTxtJusho().setValue(事業者住所 == null ? RString.EMPTY : 事業者住所.getColumnValue());
        panelDiv.getServiceJigyoshaJoho().getTxtJushoKana().setValue(
                business.get事業者住所カナ() == null ? RString.EMPTY : business.get事業者住所カナ());
        panelDiv.getServiceJigyoshaJoho().getTxtShozaiShichoson().setValue(
                business.get所在市町村() == null ? RString.EMPTY : business.get所在市町村());
        panelDiv.getServiceJigyoshaJoho().getTxtServiceTiiki().setValue(
                business.getサービス実施地域() == null ? RString.EMPTY : business.getサービス実施地域());
        panelDiv.getServiceJigyoshaJoho().getTxtShozokuNum().setValue(
                business.get所属人数() == 0 ? new Decimal("") : new Decimal(business.get所属人数()));
        panelDiv.getServiceJigyoshaJoho().getTxtRiyoshaNum().setValue(
                business.get利用者数() == 0 ? new Decimal("") : new Decimal(business.get利用者数()));
        panelDiv.getServiceJigyoshaJoho().getTxtBedNum().setValue(
                business.getベッド数() == 0 ? new Decimal("") : new Decimal(business.getベッド数()));
    }

    private void get事業者情報_代表者_開設者あり場合2(KaigoJigyosha business) {
        AtenaMeisho 宛先人名 = business.get宛先人名();
        panelDiv.getServiceJigyoshaJoho().getTxtAtesakininName().setValue(宛先人名 == null ? RString.EMPTY : 宛先人名.getColumnValue());
        AtenaKanaMeisho 宛先人名カナ = business.get宛先人名カナ();
        panelDiv.getServiceJigyoshaJoho().getTxtAtesakininNameKana().setValue(宛先人名カナ == null ? RString.EMPTY : 宛先人名カナ.getColumnValue());
        panelDiv.getServiceJigyoshaJoho().getTxtAtesakiBusho().setValue(
                business.get宛先部署() == null ? RString.EMPTY : business.get宛先部署());
        Code 法人等種別Code = business.get法人等種別();
        panelDiv.getServiceJigyoshaJoho().getDdlHojinShubetsu().setSelectedKey(法人等種別Code == null ? RString.EMPTY : 法人等種別Code.getColumnValue());
        Code 指定基準該当等事業所区分 = business.get指定_基準該当等事業所区分();
        panelDiv.getServiceJigyoshaJoho().getDdlShiteiKijungaitoKubun().setSelectedKey(
                指定基準該当等事業所区分 == null ? RString.EMPTY : 指定基準該当等事業所区分.getColumnValue());
        panelDiv.getServiceJigyoshaJoho().getTxtBiko().setValue(
                business.get備考() == null ? RString.EMPTY : business.get備考());
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaName().setValue(business.getKaigoJigyoshaDaihyoshaList().get(0).get代表者名().getColumnValue());
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaNameKana().setValue(business.getKaigoJigyoshaDaihyoshaList().get(0).get代表者名カナ().getColumnValue());
        RString 代表者役職名 = business.getKaigoJigyoshaDaihyoshaList().get(0).get代表者役職名();
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaYakushokuMei().setValue(代表者役職名 == null ? RString.EMPTY : 代表者役職名);
        YubinNo 代表者郵便番号 = business.getKaigoJigyoshaDaihyoshaList().get(0).get代表者郵便番号();
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaYubinNo().setValue(代表者郵便番号 == null ? YubinNo.EMPTY : 代表者郵便番号);
        AtenaJusho 代表者住所 = business.getKaigoJigyoshaDaihyoshaList().get(0).get代表者住所();
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaJusho().setValue(代表者住所 == null ? RString.EMPTY : 代表者住所.getColumnValue());
        RString 代表者住所カナ = business.getKaigoJigyoshaDaihyoshaList().get(0).get代表者住所カナ();
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaJushoKana().setValue(代表者住所カナ == null ? RString.EMPTY : 代表者住所カナ);
        AtenaMeisho 開設者名称 = business.getKaigoJigyoshaDaihyoshaList().get(0).get開設者名称();
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaName().setValue(開設者名称 == null ? RString.EMPTY : 開設者名称.getColumnValue());
        AtenaKanaMeisho 開設者名称カナ = business.getKaigoJigyoshaDaihyoshaList().get(0).get開設者名称カナ();
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaNameKana().setValue(開設者名称カナ == null ? RString.EMPTY : 開設者名称カナ.getColumnValue());
        YubinNo 開設者郵便番号 = business.getKaigoJigyoshaDaihyoshaList().get(0).get開設者郵便番号();
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaYubinNo().setValue(開設者郵便番号 == null ? YubinNo.EMPTY : 開設者郵便番号);
        TelNo 開設者電話番号 = business.getKaigoJigyoshaDaihyoshaList().get(0).get開設者電話番号();
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaTelNo().setValue(開設者電話番号 == null ? RString.EMPTY : 開設者電話番号.getColumnValue());
        TelNo 開設者ＦＡＸ番号 = business.getKaigoJigyoshaDaihyoshaList().get(0).get開設者ＦＡＸ番号();
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaFaxNo().setValue(開設者ＦＡＸ番号 == null ? RString.EMPTY : 開設者ＦＡＸ番号.getColumnValue());
        AtenaJusho 開設者住所 = business.getKaigoJigyoshaDaihyoshaList().get(0).get開設者住所();
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaJusho().setValue(開設者住所 == null ? RString.EMPTY : 開設者住所.getColumnValue());
        RString 開設者住所カナ = business.getKaigoJigyoshaDaihyoshaList().get(0).get開設者住所カナ();
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaJushoKana().setValue(開設者住所カナ == null ? RString.EMPTY : 開設者住所カナ);
    }

    private void get事業者情報_代表者_開設者の情報できないの場合() {
        panelDiv.getServiceJigyoshaJoho().getTxtYukoKaishiYMD().setValue(FlexibleDate.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtYukoShuryoYMD().setValue(FlexibleDate.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoshaNo().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoshaName().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoshaNameKana().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoKaishiYMD().setValue(FlexibleDate.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoKyushuYMD().setValue(FlexibleDate.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoSaikaiYMD().setValue(FlexibleDate.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJigyoHaishiYMD().setValue(FlexibleDate.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtYubinNo().setValue(YubinNo.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtTelNo().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtFaxNo().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJusho().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtJushoKana().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtShozaiShichoson().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtServiceTiiki().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtShozokuNum().setValue(null);
        panelDiv.getServiceJigyoshaJoho().getTxtRiyoshaNum().setValue(null);
        panelDiv.getServiceJigyoshaJoho().getTxtBedNum().setValue(null);
        panelDiv.getServiceJigyoshaJoho().getTxtAtesakininName().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtAtesakininNameKana().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getTxtAtesakiBusho().setValue(RString.EMPTY);
        panelDiv.getServiceJigyoshaJoho().getDdlHojinShubetsu().setSelectedKey(法人等種別);
        panelDiv.getServiceJigyoshaJoho().getDdlShiteiKijungaitoKubun().setSelectedKey(基準該当等事業所区分);
        panelDiv.getServiceJigyoshaJoho().getTxtBiko().setValue(RString.EMPTY);
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaName().setValue(RString.EMPTY);
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaNameKana().setValue(RString.EMPTY);
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaJushoKana().setValue(RString.EMPTY);
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaYakushokuMei().setValue(RString.EMPTY);
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaYubinNo().setValue(YubinNo.EMPTY);
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaJusho().setValue(RString.EMPTY);
        panelDiv.getDaihyoshaJoho().getTxtDaihyoshaJushoKana().setValue(RString.EMPTY);
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaName().setValue(RString.EMPTY);
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaYubinNo().setValue(YubinNo.EMPTY);
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaTelNo().setValue(RString.EMPTY);
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaFaxNo().setValue(RString.EMPTY);
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaJusho().setValue(RString.EMPTY);
        panelDiv.getKaisetsushaJoho().getTxtKaisetsushaJushoKana().setValue(RString.EMPTY);
    }

    /**
     * 画面初期のサービス一覧情報を設定します。
     *
     * @param サービス一覧情報List サービス一覧情報List
     */
    public void getサービス一覧情報(List<KaigoJogaiTokureiBusiness> サービス一覧情報List) {
        List<dgServiceList_Row> サービス一覧データ = new ArrayList<>();
        for (KaigoJogaiTokureiBusiness result : サービス一覧情報List) {
            dgServiceList_Row row = new dgServiceList_Row();
            row.setServiceType(
                    result.getサービス種類コード().isNullOrEmpty() ? RString.EMPTY : result.getサービス種類コード());
            TextBoxFlexibleDate 開始日 = new TextBoxFlexibleDate();
            開始日.setValue(new FlexibleDate(result.get有効開始日()));
            TextBoxFlexibleDate 終了日 = new TextBoxFlexibleDate();
            終了日.setValue(
                    result.get有効終了日() == null ? FlexibleDate.EMPTY : new FlexibleDate(result.get有効終了日()));
            row.setKaishiDate(開始日);
            row.setShuryoDate(終了日);
            row.setJigyoshaMei(
                    result.get事業者名称().isNullOrEmpty() ? RString.EMPTY : result.get事業者名称());
            row.setKanrishaMei(
                    result.get管理者氏名().isNullOrEmpty() ? RString.EMPTY : result.get管理者氏名());
            サービス一覧データ.add(row);
        }
        panelDiv.getServiceJoho().getDgServiceList().setDataSource(サービス一覧データ);
    }
}
