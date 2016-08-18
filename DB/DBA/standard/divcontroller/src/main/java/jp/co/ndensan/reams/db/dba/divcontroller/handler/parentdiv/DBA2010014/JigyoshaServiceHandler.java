/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.divcontroller.handler.parentdiv.DBA2010014;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014.JigyoshaServiceDiv;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshashiteiservice.KaigoJigyoshaShiteiService;
import jp.co.ndensan.reams.db.dbx.definition.core.codeshubetsu.DBZCodeShubetsu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1005KaigoJogaiTokureiTaishoShisetsuEntity;
import jp.co.ndensan.reams.ur.urz.business.core.hokenja.Hokenja;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaShubetsu;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja.IHokenjaManager;
import jp.co.ndensan.reams.ur.urz.service.core.hokenja._HokenjaManager;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 画面サービス登録のHandlerクラスです。
 *
 * @reamsid_L DBA-0340-060 dongyabin
 */
public class JigyoshaServiceHandler {

    private static final RString 準拠しない = new RString("0");
    private static final RString 準拠する = new RString("1");
    private static final RString 無 = new RString("1");
    private static final RString 有 = new RString("2");
    private static final RString 別表第二注２ロ該当 = new RString("3");
    private static final RString 栄養ケア_マネジメント体制 = new RString("4");
    private final JigyoshaServiceDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public JigyoshaServiceHandler(JigyoshaServiceDiv div) {
        this.div = div;
    }

    /**
     * 追加状態の画面設定します。
     *
     * @param 事業者番号 事業者番号
     */
    public void set状態_追加(RString 事業者番号,DbT1005KaigoJogaiTokureiTaishoShisetsuEntity 事業者登録情報) {
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaName().setDisabled(true);
        div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().setDisabled(false);
        div.getJigyoshaServiceKihon().getJigyosha().setDisabled(true);
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().setValue(事業者番号);
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaName().setValue(事業者登録情報.getJigyoshaMeisho().value());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNameKana().setValue(事業者登録情報.getJigyoshaKanaMeisho().value());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddress().setValue(事業者登録情報.getJigyoshaJusho());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddressKana().setValue(事業者登録情報.getJigyoshaKanaJusho());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaTelNo().setValue(事業者登録情報.getTelNo().value());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaFaxNo().setValue(事業者登録情報.getFaxNo().value());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaYubinNo().setValue(事業者登録情報.getYubinNo());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().setValue(事業者登録情報.getYukoKaishiYMD());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().setValue(事業者登録情報.getYukoShuryoYMD());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().setValue(事業者登録情報.getJigyoHaishiYMD());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().setValue(事業者登録情報.getJigyoKaishiYMD());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().setValue(事業者登録情報.getJigyoKyushiYMD());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().setValue(事業者登録情報.getJigyoSaikaiYMD());
    }

    /**
     * 修正状態の画面設定します。
     */
    public void set状態_修正() {
        div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().setDisabled(false);
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().setDisabled(true);
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().setDisabled(true);
    }

    /**
     * 修正状態の画面設定します。
     */
    public void set状態_削除() {
        div.getJigyoshaServiceKihon().setDisabled(true);
        div.getJigyoshaServiceShosai().setDisabled(true);
    }

    /**
     * 画面情報の設定します。
     *
     * @param list 事業者サービス情報
     */
    public void set画面情報(List<KaigoJigyoshaShiteiService> list) {
        if (!list.isEmpty()) {
            set画面情報(list.get(0));
        }
    }

    /**
     * 介護事業者は基本情報に準拠チェックボックスを選択します。
     *
     * @param johoList 事業者番号、有効開始日に対する介護事業者情報
     */
    public void onChange_ChkKihonJunkyoFlag(List<KaigoJigyoshaShiteiService> johoList) {
        if (div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().getSelectedKeys().contains(new RString("0"))) {
            if (!johoList.isEmpty()) {
                KaigoJigyoshaShiteiService joho = johoList.get(0);
                div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().setValue(joho.get有効開始日());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().setValue(joho.get有効終了日());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().setValue(joho.get事業者番号().getColumnValue());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaName().setValue(joho.get事業者名称().getColumnValue());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNameKana().setValue(joho.get事業者名称カナ().getColumnValue());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().setValue(joho.get事業開始日());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().setValue(joho.get事業休止日());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().setValue(joho.get事業再開日());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().setValue(joho.get事業廃止日());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaYubinNo().setValue(joho.get事業者郵便番号());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaTelNo().setValue(joho.get事業者郵便番号() == null ? RString.EMPTY : joho
                        .get事業者郵便番号().getColumnValue());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaFaxNo().setValue(joho.get事業者FAX番号() == null ? RString.EMPTY : joho
                        .get事業者FAX番号().getColumnValue());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddress().setValue(joho.get事業者住所() == null ? RString.EMPTY
                        : joho.get事業者住所().getColumnValue());
                div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddressKana().setValue(joho.get事業者住所カナ());
                div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().setValue(joho.get登録保険者番号());
                div.getJigyoshaServiceKihon().getTxtTorokuHokenshaName().setValue(get保険者名(joho.get登録保険者番号()));
                div.getJigyoshaServiceKihon().getRadJuryoininUmu().setSelectedKey(setRadio(joho.get受領委任の有無()));
                div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD().setValue(joho.get登録開始日());
                div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD().setValue(joho.get登録終了日());
                div.getJigyoshaServiceKihon().getTxtKanrishaName().setValue(joho.get管理者氏名() == null ? RString.EMPTY
                        : joho.get管理者氏名().getColumnValue());
                div.getJigyoshaServiceKihon().getTxtKanrishaNameKana().setValue(joho.get管理者氏名カナ() == null ? RString.EMPTY
                        : joho.get管理者氏名カナ().getColumnValue());
                div.getJigyoshaServiceKihon().getTxtKanrishaYubinNo().setValue(joho.get管理者住所郵便番号());
                div.getJigyoshaServiceKihon().getTxtKanrishaAddress().setValue(joho.get管理者住所() == null ? RString.EMPTY
                        : joho.get管理者住所().getColumnValue());
                div.getJigyoshaServiceKihon().getTxtKanrishaAddressKana().setValue(joho.get管理者住所カナ());
                div.getJigyoshaServiceKihon().getRadShakaiFukushihoujinKeigenjigyouJisshiUumu()
                        .setSelectedKey(setRadio(joho.get社会福祉法人軽減事業実施の有無()));
                div.getJigyoshaServiceKihon().getRadSeikatsuhogohouShiteiUmu()
                        .setSelectedKey(setRadio(joho.get生活保護法による指定の有無()));
            }
        } else {
            div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaName().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNameKana().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaYubinNo().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaTelNo().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaFaxNo().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddress().clearValue();
            div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddressKana().clearValue();
            div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().clearValue();
            div.getJigyoshaServiceKihon().getTxtTorokuHokenshaName().clearValue();
            div.getJigyoshaServiceKihon().getRadJuryoininUmu().setSelectedKey(無);
            div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD().clearValue();
            div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD().clearValue();
            div.getJigyoshaServiceKihon().getTxtKanrishaName().clearValue();
            div.getJigyoshaServiceKihon().getTxtKanrishaNameKana().clearValue();
            div.getJigyoshaServiceKihon().getTxtKanrishaYubinNo().clearValue();
            div.getJigyoshaServiceKihon().getTxtKanrishaAddress().clearValue();
            div.getJigyoshaServiceKihon().getTxtKanrishaAddressKana().clearValue();
            div.getJigyoshaServiceKihon().getRadShakaiFukushihoujinKeigenjigyouJisshiUumu()
                    .setSelectedKey(無);
            div.getJigyoshaServiceKihon().getRadSeikatsuhogohouShiteiUmu()
                    .setSelectedKey(無);
        }
    }

    /**
     * 詳細情報を表示します。
     */
    public void onClick_BtnInputShosai() {
        div.getJigyoshaServiceKihon().setDisplayNone(true);
        div.getJigyoshaServiceShosai().setDisplayNone(false);
    }

    /**
     * 基本情報を表示します。
     */
    public void onClick_BtnInputKihon() {
        div.getJigyoshaServiceKihon().setDisplayNone(false);
        div.getJigyoshaServiceShosai().setDisplayNone(true);
    }

    private void set画面情報(KaigoJigyoshaShiteiService joho) {
        List<RString> chkKihonJunkyoFlag = new ArrayList<>();
        if (無.equals(joho.get基本情報準拠区分())) {
            chkKihonJunkyoFlag.add(準拠しない);
        }
        div.getJigyoshaServiceKihon().getDdlServiceShuruiChiikiMitchaku().setSelectedKey(joho.getサービス種類コード().getColumnValue());
        div.getJigyoshaServiceKihon().getChkKihonJunkyoFlag().setSelectedItemsByKey(chkKihonJunkyoFlag);
        div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoKaishiYMD().setValue(joho.get有効開始日());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().setValue(joho.get有効終了日());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNo().setValue(joho.get事業者番号().getColumnValue());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaName().setValue(joho.get事業者名称().getColumnValue());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaNameKana().setValue(joho.get事業者名称カナ().getColumnValue());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().setValue(joho.get事業開始日());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().setValue(joho.get事業休止日());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().setValue(joho.get事業再開日());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().setValue(joho.get事業廃止日());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaYubinNo().setValue(joho.get事業者郵便番号());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaTelNo().setValue(joho.get事業者郵便番号() == null ? RString.EMPTY : joho
                .get事業者郵便番号().getColumnValue());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaFaxNo().setValue(joho.get事業者FAX番号() == null ? RString.EMPTY : joho
                .get事業者FAX番号().getColumnValue());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddress().setValue(joho.get事業者住所() == null ? RString.EMPTY
                : joho.get事業者住所().getColumnValue());
        div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddressKana().setValue(joho.get事業者住所カナ());
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().setValue(joho.get登録保険者番号());
        div.getJigyoshaServiceKihon().getTxtTorokuHokenshaName().setValue(get保険者名(joho.get登録保険者番号()));
        div.getJigyoshaServiceKihon().getRadJuryoininUmu().setSelectedKey(setRadio(joho.get受領委任の有無()));
        div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD().setValue(joho.get登録開始日());
        div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD().setValue(joho.get登録終了日());
        div.getJigyoshaServiceKihon().getTxtKanrishaName().setValue(joho.get管理者氏名() == null ? RString.EMPTY
                : joho.get管理者氏名().getColumnValue());
        div.getJigyoshaServiceKihon().getTxtKanrishaNameKana().setValue(joho.get管理者氏名カナ() == null ? RString.EMPTY
                : joho.get管理者氏名カナ().getColumnValue());
        div.getJigyoshaServiceKihon().getTxtKanrishaYubinNo().setValue(joho.get管理者住所郵便番号());
        div.getJigyoshaServiceKihon().getTxtKanrishaAddress().setValue(joho.get管理者住所() == null ? RString.EMPTY
                : joho.get管理者住所().getColumnValue());
        div.getJigyoshaServiceKihon().getTxtKanrishaAddressKana().setValue(joho.get管理者住所カナ());
        div.getJigyoshaServiceKihon().getRadShakaiFukushihoujinKeigenjigyouJisshiUumu()
                .setSelectedKey(setRadio(joho.get社会福祉法人軽減事業実施の有無()));
        div.getJigyoshaServiceKihon().getRadSeikatsuhogohouShiteiUmu()
                .setSelectedKey(setRadio(joho.get生活保護法による指定の有無()));
        set事業者サービス詳細情報エリア(joho);
        set個別リハビリテーション提供体制(joho);
        set介護支援専門員数(joho);
        set訪問介護員数(joho);
        set個別リハビリテーション提供体制(joho);
    }

    private void set事業者サービス詳細情報エリア(KaigoJigyoshaShiteiService joho) {
        // TODO 内部QA：1008　「施設等の区分」と「人員配置区分」の設定を不明です。

        div.getJigyoshaServiceShosai().getRadTokubetsuChiikiKasanUmu().setSelectedKey(setRadio(joho.get特別地域加算の有無()));
        div.getJigyoshaServiceShosai().getRadKinkyujiHomonkaigoKasanUmu().setSelectedKey(setRadio(joho.get緊急時訪問介護加算の有無()));
        div.getJigyoshaServiceShosai().getRadTokubetsuKanriTaisei().setSelectedKey(setRadio(joho.get特別管理体制()));
        div.getJigyoshaServiceShosai().getRadKinoKunrenShidoTaiseiUmu().setSelectedKey(setRadio(joho.get機能訓練指導体制の有無()));
        div.getJigyoshaServiceShosai().getRadShokujiTeikyoTaiseiUmu().setSelectedKey(setRadio(joho.get食事提供体制の有無()));
        div.getJigyoshaServiceShosai().getRadNyuyokuKaijoTaiseiUmu().setSelectedKey(setRadio(joho.get入浴介助体制の有無()));
        div.getJigyoshaServiceShosai().getRadTokubetsuNyuyokuKaijoTaiseiUmu().setSelectedKey(setRadio(joho.get特別入浴介助体制の有無()));
        div.getJigyoshaServiceShosai().getRadJoukinsenjuIshiHaichiUmu().setSelectedKey(setRadio(joho.get常勤専従医師配置の有無()));
        div.getJigyoshaServiceShosai().getRadIshiHaichiKijun().setSelectedKey(setRadio(joho.get医師の配置基準()));
        div.getJigyoshaServiceShosai().getRadSeisinkaIshiTeikitekiRyouyousidouUmu().setSelectedKey(setRadio(joho.get精神科医師定期的療養指導の有無()));
        // TODO 内部QA：1008 「夜間勤務条件基準」の設定不明です。
        div.getJigyoshaServiceShosai().getRadNinchishouSenmontouUmu().setSelectedKey(setRadio(joho.get認知症専門棟の有無()));
        div.getJigyoshaServiceShosai().getDdlShokujiTeikyoJokyo().setSelectedKey(set食事提供の状況DDL(joho.get食事提供の状況()));
        div.getJigyoshaServiceShosai().getRadSougeiTaisei().setSelectedKey(setRadio(joho.get送迎体制()));
        setリハビリテーション提供体制(joho);
        div.getJigyoshaServiceShosai().getRadRehabilitationKasanJokyoUmu().setSelectedKey(setRadio(joho.getリハビリテーションの加算状況の有無()));
        // TODO 内部QA：1008 「療養環境基準」の設定不明です。
        // div.getJigyoshaServiceShosai().getRadIshiKetuinGenzanJokyoUmu().setSelectedKey(setRadio(joho.get療養環境基準()));
        div.getJigyoshaServiceShosai().getRadIshiKetuinGenzanJokyoUmu().setSelectedKey(setRadio(joho.get医師の欠員による減算の状況の有無()));
        div.getJigyoshaServiceShosai().getRadKangoShokuinKetsuinGenzanJokyoUmu().setSelectedKey(setRadio(joho
                .get看護職員の欠員による減算の状況の有無()));
        div.getJigyoshaServiceShosai().getRadRigakuRyouhousiKetsuinGenzanJokyoUmu().setSelectedKey(setRadio(joho
                .get理学療法士の欠員による減算の状況の有無()));
        div.getJigyoshaServiceShosai().getRadSagyouRyouhousiKetsuinGenzanJokyoUmu().setSelectedKey(setRadio(joho
                .get作業療法士の欠員による減算の状況の有無()));
        div.getJigyoshaServiceShosai().getRadKaigoShokuinKetsuinGenzanJokyoUmu().setSelectedKey(setRadio(joho
                .get介護職員の欠員による減算の状況の有無()));
        div.getJigyoshaServiceShosai().getRadKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu().setSelectedKey(setRadio(joho
                .get介護支援専門員の欠員による減算の状況の有無()));
        div.getJigyoshaServiceShosai().getRadKaigoJujishaKetsuinGenzanJokyoUmu().setSelectedKey(setRadio(joho
                .get介護従業者の欠員による減算の状況の有無()));
        div.getJigyoshaServiceShosai().getRadKansenTaisakuSidoKanriUmu().setSelectedKey(setRadio(joho
                .get感染対策指導管理の有無()));
        div.getJigyoshaServiceShosai().getRadJushoHifuKaiyouShidoKanriUmu().setSelectedKey(setRadio(joho
                .get重症皮膚潰瘍指導管理の有無()));
        div.getJigyoshaServiceShosai().getRadYakuzaiKaniriShidoUmu().setSelectedKey(setRadio(joho
                .get薬剤管理指導の有無()));
        div.getJigyoshaServiceShosai().getRadShogaishaSeikatsuShienTaiseiUmu().setSelectedKey(setRadio(joho
                .get障害者生活支援体制の有無()));
        div.getJigyoshaServiceShosai().getDdlChiikiKubun().setSelectedKey(setRadio(joho.get地域区分コード()));
        div.getJigyoshaServiceShosai().getRadJikanEnchoServiceTaisei().setSelectedKey(setRadio(joho.get時間延長サービス体制()));
        div.getJigyoshaServiceShosai().getRadKobetsuRehabilitationTeikyoTaisei().setSelectedKey(setRadio(joho
                .get個別リハビリテーション提供体制()));
        div.getJigyoshaServiceShosai().getRadKyojuhiTaisaku().setSelectedKey(setRadio(joho
                .get居住費対策()));
        div.getJigyoshaServiceShosai().getRadYakanCareUmu().setSelectedKey(setRadio(joho
                .get夜間ケアの有無()));
        div.getJigyoshaServiceShosai().getRadRehabilitationKinoKyokaUmu().setSelectedKey(setRadio(joho
                .getリハビリテーション機能強化の有無()));

    }

    private void setリハビリテーション提供体制(KaigoJigyoshaShiteiService joho) {
        div.getJigyoshaServiceShosai().getRadSogoRehaShisetsuUmu().setSelectedKey(setRadio(joho
                .getリハビリテーション提供体制_総合リハビリテーション施設_の有無()));
        div.getJigyoshaServiceShosai().getRadRigakuRyohoIIUmu().setSelectedKey(setRadio(joho
                .getリハビリテーション提供体制_理学療法Ⅱ_の有無()));
        div.getJigyoshaServiceShosai().getRadRigakuRyohoIIIUmu().setSelectedKey(setRadio(joho
                .getリハビリテーション提供体制_理学療法Ⅲ_の有無()));
        div.getJigyoshaServiceShosai().getRadSagyoRyohoIIUmu().setSelectedKey(setRadio(joho
                .getリハビリテーション提供体制_総合リハビリテーション施設_の有無()));
        div.getJigyoshaServiceShosai().getRadSeisinkaSagyouRyohoUmu().setSelectedKey(setRadio(joho
                .getリハビリテーション提供体制_精神科作業療法_の有無()));
        div.getJigyoshaServiceShosai().getRadSonotaUmu().setSelectedKey(setRadio(joho
                .getリハビリテーション提供体制_その他_の有無()));
    }

    private void set個別リハビリテーション提供体制(KaigoJigyoshaShiteiService joho) {
        div.getJigyoshaServiceShosai().getRadKobetsuSogoRehaShisetsuUmu().setSelectedKey(setRadio(joho
                .get個別リハビリテーション提供体制_総合リハビリテーション施設_の有無()));
        div.getJigyoshaServiceShosai().getRadKobetsuRigakuRyohoIIUmu1().setSelectedKey(setRadio(joho
                .get個別リハビリテーション提供体制_理学療法Ⅱ_の有無1()));
        div.getJigyoshaServiceShosai().getRadKobetsuRigakuRyohoIIIUmu().setSelectedKey(setRadio(joho
                .get個別リハビリテーション提供体制_理学療法Ⅲ_の有無()));
        div.getJigyoshaServiceShosai().getRadKobetsuSagyoRyohoIIUmu().setSelectedKey(setRadio(joho
                .get個別リハビリテーション提供体制_作業療法Ⅱ_の有無()));
        div.getJigyoshaServiceShosai().getRadKobetsuGengoChokakuRyohoIUmu().setSelectedKey(setRadio(joho
                .get個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無()));
        div.getJigyoshaServiceShosai().getRadKobetsuGengoChokakuRyohoIIUmu().setSelectedKey(setRadio(joho
                .get個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無()));
        div.getJigyoshaServiceShosai().getRadGengoChokakushiKetsuinGenzanJokyoUmu().setSelectedKey(setRadio(joho
                .get言語聴覚士の欠員による減算の状況の有無()));
        div.getJigyoshaServiceShosai().getDdlEiyouKanriHyoka().setSelectedKey(set栄養管理の評価DDL(joho
                .get栄養管理の評価()));
        div.getJigyoshaServiceShosai().getRadTokuteijigyoushoKasanHomonKaigoUmu().setSelectedKey(setRadio(joho
                .get特定事業所加算_訪問介護_の有無()));
        div.getJigyoshaServiceShosai().getRadJakunenseiNinchishoCareTaiseiUmu().setSelectedKey(setRadio(joho
                .get若年性認知症ケア体制の有無()));
        div.getJigyoshaServiceShosai().getRadUndokiKinoKojoTaiseiUmu().setSelectedKey(setRadio(joho
                .get運動器機能向上体制の有無()));
        div.getJigyoshaServiceShosai().getRadEiyoManagementKaizenTaiseiUmu().setSelectedKey(setRadio(joho
                .get栄養マネジメント_改善_体制の有無()));
        div.getJigyoshaServiceShosai().getRadKokuKinoKojoTaiseiUmu().setSelectedKey(setRadio(joho
                .get口腔機能向上体制の有無()));
        div.getJigyoshaServiceShosai().getRadJigyoshoHyokaKasanMoshideUmu().setSelectedKey(setRadio(joho
                .get事業所評価加算_申出_の有無()));
        div.getJigyoshaServiceShosai().getRadJigyoshoHyokaKasanKetteiUmu().setSelectedKey(setRadio(joho
                .get事業所評価加算_決定_の有無()));
        div.getJigyoshaServiceShosai().getRadKinkyuUkeireTaiseiUmu().setSelectedKey(setRadio(joho
                .get緊急受入体制の有無()));
        div.getJigyoshaServiceShosai().getRadYakanKangoTaiseiUmu().setSelectedKey(setRadio(joho
                .get夜間看護体制の有無()));
        // TODO 内部QA：1008 「特定事業所加算（居宅介護支援）」の設定不明です。
        // div.getJigyoshaServiceShosai().getRadGengoChokakushiKetsuinGenzanJokyoUmu().setSelectedKey(setRadio(joho
        //        .get言語聴覚士の欠員による減算の状況の有無()));
    }

    private void set介護支援専門員数(KaigoJigyoshaShiteiService joho) {
        div.getJigyoshaServiceShosai().getTxtKaigoShienSemmoninSenjuJokinshaNinsu().setValue(intToDecimal(joho.
                get介護支援専門員数_専従の常勤者_()));
        div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninSenjuHijokinshaNinsu().setValue(intToDecimal(joho.
                get介護支援専門員数_専従の非常勤者_()));
        div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninKemmuJokinshaNinsu().setValue(intToDecimal(joho.
                get介護支援専門員数_兼務の常勤者_()));
        div.getJigyoshaServiceShosai().getTxtKaigoSienSemmoninKemmuHijokinshaNinsu().setValue(intToDecimal(joho.
                get介護支援専門員数_兼務の非常勤者_()));
        div.getJigyoshaServiceShosai().getTxtHomonkaigoServiceTeikyoSekininshaNinsu().setValue(intToDecimal(joho.
                get訪問介護サービス提供責任者数()));
    }

    private void set訪問介護員数(KaigoJigyoshaShiteiService joho) {
        div.getJigyoshaServiceShosai().getTxtHomonkaigoSenjuJokinshaNinsu().setValue(intToDecimal(joho.
                get訪問介護員数_専従の常勤者_()));
        div.getJigyoshaServiceShosai().getTxtHomonkaigoSenjuHijokinshaNinsu().setValue(intToDecimal(joho.
                get訪問介護員数_専従の非常勤者_()));
        div.getJigyoshaServiceShosai().getTxtHomonkaigoKemmuJokinshaNinsu().setValue(intToDecimal(joho.
                get訪問介護員数_兼務の常勤者_()));
        div.getJigyoshaServiceShosai().getTxtHomonkaigoKemmuHijokinshaNinsu().setValue(intToDecimal(joho.
                get訪問介護員数_兼務の非常勤者_()));
        div.getJigyoshaServiceShosai().getTxtHomonkaigoJokinKanzangoNinsu().setValue(intToDecimal(joho.
                get訪問介護員数_常勤換算後の人数_()));
        div.getJigyoshaServiceShosai().getTxtRiyoTeiinNinsu().setValue(intToDecimal(joho.get利用定員数()));
        div.getJigyoshaServiceShosai().getTxtShiteiYukoKaishiYMD().setValue(joho.get指定有効開始日());
        div.getJigyoshaServiceShosai().getTxtShiteiYukoShuryoYMD().setValue(joho.get指定有効終了日());
        div.getJigyoshaServiceShosai().getRadShiteiKoshinShinseichuKubun().setSelectedKey(setRadio(joho.get指定更新申請中区分()));
        div.getJigyoshaServiceShosai().getTxtKoryokuTeishiKaishiYMD().setValue(joho.get効力停止開始日());
        div.getJigyoshaServiceShosai().getTxtKoryokuTeishiShuryoYMD().setValue(joho.get効力停止終了日());
        div.getJigyoshaServiceShosai().getRadDaikiboJigyoshaGaitoUmu().setSelectedKey(setRadio(joho.get大規模事業所該当の有無()));
        div.getJigyoshaServiceShosai().getRadJunUnitCareTaiseiUmu().setSelectedKey(setRadio(joho.get準ユニットケア体制の有無()));
        div.getJigyoshaServiceShosai().getRadJudokaTaioTaiseiUmu().setSelectedKey(setRadio(joho.get重度化対応体制の有無()));
        div.getJigyoshaServiceShosai().getRadIryoRenkeiTaiseiUmu().setSelectedKey(setRadio(joho.get医療連携体制の有無()));
        div.getJigyoshaServiceShosai().getRadUnitCareTaiseiUmu().setSelectedKey(setRadio(joho.getユニットケア体制の有無()));
        div.getJigyoshaServiceShosai().getRadZaitakuNyushoSogoRiyoTaiseiUmu().setSelectedKey(setRadio(joho.get在宅_入所相互利用体制の有無()));
        div.getJigyoshaServiceShosai().getRadTerminalCareTaiseiUmu().setSelectedKey(setRadio(joho.getターミナルケア体制_看取り介護体制_の有無()));
        div.getJigyoshaServiceShosai().getRadShintaiKosokuHaishiTorikumiUmu().setSelectedKey(setRadio(joho.get身体拘束廃止取組の有無()));
        div.getJigyoshaServiceShosai().getRadShokiboKyotenShugoTaiseiUmu().setSelectedKey(setRadio(joho.get小規模拠点集合体制の有無()));
        div.getJigyoshaServiceShosai().getRadNinchishoCareKasanUmu().setSelectedKey(setRadio(joho.get認知症ケア加算の有無()));
        // TODO 内部QA：1008 「個別機能訓練体制の有無」の設定不明です。
        div.getJigyoshaServiceShosai().getRadKobetsuRigakuRyohoIUmu().setSelectedKey(setRadio(joho.
                get個別リハビリテーション提供体制_理学療法Ⅰ_の有無()));
        div.getJigyoshaServiceShosai().getRadRigakuRyohoIIUmu2().setSelectedKey(setRadio(joho.
                get個別リハビリテーション提供体制_理学療法Ⅱ_の有無2()));
        div.getJigyoshaServiceShosai().getRadKobetsuSagyoRyohoUmu().setSelectedKey(setRadio(joho.
                get個別リハビリテーション提供体制_作業療法_の有無()));
        div.getJigyoshaServiceShosai().getRadKobetsuGengoChokakuRyohoUmu().setSelectedKey(setRadio(joho.
                get個別リハビリテーション提供体制_言語聴覚療法_の有無()));
        div.getJigyoshaServiceShosai().getRadKobetsuSonotaUmu().setSelectedKey(setRadio(joho.
                get個別リハビリテーション提供体制_その他_の有無()));
        div.getJigyoshaServiceShosai().getRadSetsubiKijun().setSelectedKey(setRadio(joho.get設備基準()));
        div.getJigyoshaServiceShosai().getRadRyoyoTaiseiIjiTokubetsuKasan().setSelectedKey(setRadio(joho.
                get療養体制維持特別加算()));
        div.getJigyoshaServiceShosai().getRadKobetsuRehaShidoKanriUmu().setSelectedKey(setRadio(joho.
                get個別リハビリテーション提供体制_リハビリテーション指導管理_の有無()));
        div.getJigyoshaServiceShosai().getRadSankyuHelperTaisei().setSelectedKey(setRadio(joho.get３級ヘルパー体制()));
        div.getRadChuSankanChiikiShokiboJigyoshoKasanChiiki().setSelectedKey(setRadio(joho.
                get中山間地域等における小規模事業所加算_地域に関する状況_()));
        div.getRadChuSankanChiikiShokiboJigyoshoKasanKibo().setSelectedKey(setRadio(joho.
                get中山間地域等における小規模事業所加算_規模に関する状況_()));
        // TODO 内部QA：1008　「サービス提供体制強化加算」の設定を不明です。
        div.getJigyoshaServiceShosai().getRadNinchishoTankiShuchuRehabilitationKasan().setSelectedKey(setRadio(joho.
                get認知症短期集中リハビリテーション加算()));
        div.getJigyoshaServiceShosai().getRadKakunenseiNinchishoRiyoushaUkeeireKasan().setSelectedKey(setRadio(joho.
                get若年性認知症利用者_入所者_患者_受入加算()));
        div.getJigyoshaServiceShosai().getRadKangoTaiseiKasan().setSelectedKey(setRadio(joho.get看護体制加算()));
        div.getJigyoshaServiceShosai().getRadYakinShokuinHaichiKasan().setSelectedKey(setRadio(joho.get夜勤職員配置加算()));
        div.getJigyoshaServiceShosai().getRadRyoyoShokuKasan().setSelectedKey(setRadio(joho.get療養食加算()));
        div.getJigyoshaServiceShosai().getRadNichijoSeikatsuKeizokuShienKasan().setSelectedKey(setRadio(joho.get日常生活継続支援加算()));
        div.getJigyoshaServiceShosai().getRadNinchishoSemmonCareKasan().setSelectedKey(set食事提供の状況DDL(joho.get認知症専門ケア加算()));
        div.getJigyoshaServiceShosai().getRad24JikanTsuhoTaioKasan().setSelectedKey(setRadio(joho.get２４時間通報対応加算()));
        div.getJigyoshaServiceShosai().getRadKangoShokuinHaichiKasan().setSelectedKey(set食事提供の状況DDL(joho.get看護職員配置加算()));
        div.getJigyoshaServiceShosai().getRadYakanCareKasan().setSelectedKey(setRadio(joho.get夜間ケア加算()));
        div.getJigyoshaServiceShosai().getRadShudanCommunicationRyohoUmu().setSelectedKey(setRadio(joho.get集団コミュニケーション療法の有無()));
        div.getJigyoshaServiceShosai().getRadServiceTeikyoTaiseiKyokaKasanKaradokogata().setSelectedKey(set栄養管理の評価DDL(joho.
                getサービス提供体制強化加算_空床型_()));
        div.getJigyoshaServiceShosai().getRadNitchuShintaikaigoTaise20funmimanUmu().setSelectedKey(setRadio(joho.
                get日中の身体介護２０分未満体制の有無()));
        div.getJigyoshaServiceShosai().getRadServiceTeikyoSekininshaTaiseiUmu().setSelectedKey(setRadio(joho.getサービス提供責任者体制の有無()));
        div.getJigyoshaServiceShosai().getRadDoitsuTatemonoKyojuRiyoshaGenzanUmu().setSelectedKey(setRadio(joho.get同一建物に居住する利用者の減算の有無()));
        div.getJigyoshaServiceShosai().getRadKinkyuTankiNyushoTaiseiKakuhoKasan().setSelectedKey(setRadio(joho.get緊急短期入所体制確保加算()));
        div.getJigyoshaServiceShosai().getRadZaitakuFukkiZaitakuRyoyoShienKinoKasan().setSelectedKey(setRadio(joho.get在宅復帰_在宅療養支援機能加算()));
        div.getJigyoshaServiceShosai().getRadSeikatuKinoKojoGroupKatsudoKasan().setSelectedKey(setRadio(joho.get生活機能向上グループ活動加算()));
        div.getJigyoshaServiceShosai().getRadKaigoShokuinShoguKaizenKasan().setSelectedKey(set栄養管理の評価DDL(joho.get介護職員処遇改善加算()));
    }

    /**
     * 事業者サービスDivの設定します。
     *
     * @param business 事業者サービスDiv
     * @return KaigoJigyoshaShiteiService
     */
    public KaigoJigyoshaShiteiService set事業者サービスDiv(KaigoJigyoshaShiteiService business) {
        business = set事業者サービス情報(business);
        business = set事業者サービス情報_2(business);
        return business;
    }

    private KaigoJigyoshaShiteiService set事業者サービス情報(KaigoJigyoshaShiteiService joho) {
        joho = joho.createBuilderForEdit().set異動日(FlexibleDate.getNowDate()).build();
        joho = joho.createBuilderForEdit().set異動事由(new RString("01")).build();
        joho = joho.createBuilderForEdit().set基本情報準拠区分(set介護事業者は基本情報に準拠(div.getJigyoshaServiceKihon().
                getChkKihonJunkyoFlag().getSelectedKeys())).build();
        joho = joho.createBuilderForEdit().set有効終了日(div.getJigyoshaServiceKihon().getJigyosha().getTxtYukoShuryoYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set事業者名称(new AtenaMeisho(div.getJigyoshaServiceKihon().getJigyosha().
                getTxtJigyoshaName().getValue())).build();
        joho = joho.createBuilderForEdit().set事業者名称カナ(new AtenaKanaMeisho(div.getJigyoshaServiceKihon().getJigyosha().
                getTxtJigyoshaNameKana().getValue())).build();
        joho = joho.createBuilderForEdit().set事業開始日(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKaishiYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set事業休止日(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoKyushiYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set事業再開日(div.getJigyoshaServiceKihon().getJigyosha().getTxtJikyoSaikaiYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set事業廃止日(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoHaishiYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set事業者郵便番号(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaYubinNo().getValue()).build();
        joho = joho.createBuilderForEdit().set事業者電話番号(new TelNo(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaTelNo().getValue())).build();
        joho = joho.createBuilderForEdit().set事業者FAX番号(new TelNo(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaFaxNo().getValue())).build();
        joho = joho.createBuilderForEdit().set事業者住所(new AtenaJusho(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddress().getValue())).build();
        joho = joho.createBuilderForEdit().set事業者住所カナ(div.getJigyoshaServiceKihon().getJigyosha().getTxtJigyoshaAddressKana().getValue()).build();
        joho = joho.createBuilderForEdit().set登録保険者番号(div.getJigyoshaServiceKihon().getTxtTorokuHokenshaNo().getValue()).build();
        joho = joho.createBuilderForEdit().set受領委任の有無(stringToCode(div.getJigyoshaServiceKihon().getRadJuryoininUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set登録開始日(div.getJigyoshaServiceKihon().getTxtTorokuKaishiYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set登録終了日(div.getJigyoshaServiceKihon().getTxtTorokuShuryoYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set管理者氏名(new AtenaMeisho(div.getJigyoshaServiceKihon().getTxtKanrishaName().getValue())).build();
        joho = joho.createBuilderForEdit().set管理者氏名カナ(new AtenaKanaMeisho(div.getJigyoshaServiceKihon().getTxtKanrishaNameKana().getValue())).build();
        joho = joho.createBuilderForEdit().set管理者住所郵便番号(div.getJigyoshaServiceKihon().getTxtKanrishaYubinNo().getValue()).build();
        joho = joho.createBuilderForEdit().set管理者住所(new AtenaJusho(div.getJigyoshaServiceKihon().getTxtKanrishaAddress().getValue())).build();
        joho = joho.createBuilderForEdit().set管理者住所カナ(div.getJigyoshaServiceKihon().getTxtKanrishaAddressKana().getValue()).build();
        joho = joho.createBuilderForEdit().set社会福祉法人軽減事業実施の有無(stringToCode(div
                .getJigyoshaServiceKihon().getRadShakaiFukushihoujinKeigenjigyouJisshiUumu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set生活保護法による指定の有無(stringToCode(div.
                getJigyoshaServiceKihon().getRadSeikatsuhogohouShiteiUmu().getSelectedKey())).build();
        // TODO 内部QA：1008 「施設等の区分」と「人員配置区分」の設定不明です。
        joho = joho.createBuilderForEdit().set特別地域加算の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadTokubetsuChiikiKasanUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set緊急時訪問介護加算の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKinkyujiHomonkaigoKasanUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set特別管理体制(stringToCode(div.getJigyoshaServiceShosai().getRadTokubetsuKanriTaisei().getSelectedKey()))
                .build();
        joho = joho.createBuilderForEdit().set機能訓練指導体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKinoKunrenShidoTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set食事提供体制の有無(stringToCode(div
                .getJigyoshaServiceShosai().getRadShokujiTeikyoTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set入浴介助体制の有無(stringToCode(div.getJigyoshaServiceShosai().getRadNyuyokuKaijoTaiseiUmu().getSelectedKey()))
                .build();
        joho = joho.createBuilderForEdit().set特別入浴介助体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadTokubetsuNyuyokuKaijoTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set常勤専従医師配置の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadJoukinsenjuIshiHaichiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set医師の配置基準(stringToCode(div.getJigyoshaServiceShosai().getRadIshiHaichiKijun().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set精神科医師定期的療養指導の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadSeisinkaIshiTeikitekiRyouyousidouUmu().getSelectedKey())).build();
        // TODO 内部QA：1008　「夜間勤務条件基準」の設定不明です。
        joho = joho.createBuilderForEdit().set認知症専門棟の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadNinchishouSenmontouUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set食事提供の状況(stringToCode(div.getJigyoshaServiceShosai().getDdlShokujiTeikyoJokyo().getSelectedKey()))
                .build();
        joho = joho.createBuilderForEdit().set送迎体制(stringToCode(div.getJigyoshaServiceShosai().getRadSougeiTaisei().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setリハビリテーション提供体制_総合リハビリテーション施設_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadSogoRehaShisetsuUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setリハビリテーション提供体制_理学療法Ⅱ_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadRigakuRyohoIIUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setリハビリテーション提供体制_理学療法Ⅲ_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadRigakuRyohoIIIUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setリハビリテーション提供体制_作業療法Ⅱ_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadSagyoRyohoIIUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setリハビリテーション提供体制_精神科作業療法_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadSeisinkaSagyouRyohoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setリハビリテーション提供体制_その他_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadSonotaUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setリハビリテーションの加算状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadRehabilitationKasanJokyoUmu().getSelectedKey())).build();
        // TODO 内部QA：1008　「療養環境基準」の設定を不明です。
        joho = joho.createBuilderForEdit().set医師の欠員による減算の状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadIshiKetuinGenzanJokyoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set看護職員の欠員による減算の状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKangoShokuinKetsuinGenzanJokyoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set理学療法士の欠員による減算の状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadRigakuRyouhousiKetsuinGenzanJokyoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set作業療法士の欠員による減算の状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadSagyouRyouhousiKetsuinGenzanJokyoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set介護職員の欠員による減算の状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKaigoShokuinKetsuinGenzanJokyoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set介護支援専門員の欠員による減算の状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKaigoSienSenmoninShokuinKetsuinGenzanJokyoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set介護従業者の欠員による減算の状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKaigoJujishaKetsuinGenzanJokyoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set感染対策指導管理の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKansenTaisakuSidoKanriUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set重症皮膚潰瘍指導管理の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadJushoHifuKaiyouShidoKanriUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set薬剤管理指導の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadYakuzaiKaniriShidoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set障害者生活支援体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadShogaishaSeikatsuShienTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set地域区分コード(stringToCode(div.
                getJigyoshaServiceShosai().getDdlChiikiKubun().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set時間延長サービス体制(stringToCode(div.
                getJigyoshaServiceShosai().getRadJikanEnchoServiceTaisei().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制(stringToCode(div.
                getJigyoshaServiceShosai().getRadKobetsuRehabilitationTeikyoTaisei().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set居住費対策(stringToCode(div.
                getJigyoshaServiceShosai().getRadKyojuhiTaisaku().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set夜間ケアの有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadYakanCareUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setリハビリテーション機能強化の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadRehabilitationKinoKyokaUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_総合リハビリテーション施設_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKobetsuSogoRehaShisetsuUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_理学療法Ⅱ_の有無1(stringToCode(div.
                getJigyoshaServiceShosai().getRadKobetsuRigakuRyohoIIUmu1().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_理学療法Ⅲ_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKobetsuRigakuRyohoIIIUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_作業療法Ⅱ_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKobetsuSagyoRyohoIIUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_言語聴覚療法Ⅰ_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKobetsuGengoChokakuRyohoIUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_言語聴覚療法Ⅱ_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKobetsuGengoChokakuRyohoIIUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set言語聴覚士の欠員による減算の状況の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadGengoChokakushiKetsuinGenzanJokyoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set栄養管理の評価(stringToCode(div.
                getJigyoshaServiceShosai().getDdlEiyouKanriHyoka().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set特定事業所加算_訪問介護_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadTokuteijigyoushoKasanHomonKaigoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set若年性認知症ケア体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadJakunenseiNinchishoCareTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set運動器機能向上体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadUndokiKinoKojoTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set栄養マネジメント_改善_体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadEiyoManagementKaizenTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set口腔機能向上体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKokuKinoKojoTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set事業所評価加算_申出_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadJigyoshoHyokaKasanMoshideUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set事業所評価加算_決定_の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadJigyoshoHyokaKasanKetteiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set緊急受入体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadKinkyuUkeireTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set夜間看護体制の有無(stringToCode(div.
                getJigyoshaServiceShosai().getRadYakanKangoTaiseiUmu().getSelectedKey())).build();
        return joho;
    }

    private KaigoJigyoshaShiteiService set事業者サービス情報_2(KaigoJigyoshaShiteiService joho) {
        // TODO 内部QA：1008 「特定事業所加算（居宅介護支援）」の設定を不明です。
        joho = joho.createBuilderForEdit().set介護支援専門員数_専従の常勤者_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtKaigoShienSemmoninSenjuJokinshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set介護支援専門員数_専従の非常勤者_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtKaigoSienSemmoninSenjuHijokinshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set介護支援専門員数_兼務の非常勤者_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtKaigoSienSemmoninKemmuHijokinshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set介護支援専門員数_兼務の常勤者_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtKaigoSienSemmoninKemmuJokinshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set訪問介護サービス提供責任者数(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtHomonkaigoServiceTeikyoSekininshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set訪問介護員数_専従の常勤者_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtHomonkaigoSenjuJokinshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set訪問介護員数_専従の非常勤者_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtHomonkaigoSenjuHijokinshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set訪問介護員数_兼務の常勤者_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtHomonkaigoKemmuJokinshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set訪問介護員数_兼務の非常勤者_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtHomonkaigoKemmuHijokinshaNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set訪問介護員数_常勤換算後の人数_(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtHomonkaigoJokinKanzangoNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set利用定員数(decimalToInt(div.getJigyoshaServiceShosai().
                getTxtRiyoTeiinNinsu().getValue())).build();
        joho = joho.createBuilderForEdit().set指定有効開始日(div.getJigyoshaServiceShosai().getTxtShiteiYukoKaishiYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set指定有効終了日(div.getJigyoshaServiceShosai().getTxtShiteiYukoShuryoYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set指定更新申請中区分(stringToCode(div.getJigyoshaServiceShosai()
                .getRadShiteiKoshinShinseichuKubun().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set効力停止開始日(div.getJigyoshaServiceShosai().getTxtKoryokuTeishiKaishiYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set効力停止終了日(div.getJigyoshaServiceShosai().getTxtKoryokuTeishiShuryoYMD().getValue()).build();
        joho = joho.createBuilderForEdit().set大規模事業所該当の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadDaikiboJigyoshaGaitoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set準ユニットケア体制の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadJunUnitCareTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set重度化対応体制の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadJudokaTaioTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set医療連携体制の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadIryoRenkeiTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setユニットケア体制の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadUnitCareTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set在宅_入所相互利用体制の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadZaitakuNyushoSogoRiyoTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setターミナルケア体制_看取り介護体制_の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadTerminalCareTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set身体拘束廃止取組の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadShintaiKosokuHaishiTorikumiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set小規模拠点集合体制の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadShokiboKyotenShugoTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set認知症ケア加算の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadNinchishoCareKasanUmu().getSelectedKey())).build();
        // TODO 内部QA：1008　「個別機能訓練体制の有無」の設定不明です。
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_理学療法Ⅰ_の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKobetsuRigakuRyohoIUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_理学療法Ⅱ_の有無2(stringToCode(div.getJigyoshaServiceShosai()
                .getRadRigakuRyohoIIUmu2().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_作業療法_の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKobetsuSagyoRyohoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_言語聴覚療法_の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKobetsuGengoChokakuRyohoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_その他_の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKobetsuSonotaUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set設備基準(stringToCode(div.getJigyoshaServiceShosai()
                .getRadSetsubiKijun().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set療養体制維持特別加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadRyoyoTaiseiIjiTokubetsuKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set個別リハビリテーション提供体制_リハビリテーション指導管理_の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKobetsuRehaShidoKanriUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set３級ヘルパー体制(stringToCode(div.getJigyoshaServiceShosai()
                .getRadSankyuHelperTaisei().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set中山間地域等における小規模事業所加算_地域に関する状況_(stringToCode(div.getJigyoshaServiceShosai()
                .getRadChuSankanChiikiShokiboJigyoshoKasanChiiki().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set中山間地域等における小規模事業所加算_規模に関する状況_(stringToCode(div.getJigyoshaServiceShosai()
                .getRadChuSankanChiikiShokiboJigyoshoKasanKibo().getSelectedKey())).build();
        // TODO 内部QA：1008　「サービス提供体制強化加算」の設定不明です。
        joho = joho.createBuilderForEdit().set認知症短期集中リハビリテーション加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadNinchishoTankiShuchuRehabilitationKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set若年性認知症利用者_入所者_患者_受入加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKakunenseiNinchishoRiyoushaUkeeireKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set看護体制加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKangoTaiseiKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set夜勤職員配置加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadYakinShokuinHaichiKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set療養食加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadRyoyoShokuKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set日常生活継続支援加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadNichijoSeikatsuKeizokuShienKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set認知症専門ケア加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadNinchishoSemmonCareKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set２４時間通報対応加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRad24JikanTsuhoTaioKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set看護職員配置加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKangoShokuinHaichiKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set夜間ケア加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadYakanCareKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set集団コミュニケーション療法の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadShudanCommunicationRyohoUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setサービス提供体制強化加算_空床型_(stringToCode(div.getJigyoshaServiceShosai()
                .getRadServiceTeikyoTaiseiKyokaKasanKaradokogata().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set日中の身体介護２０分未満体制の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadNitchuShintaikaigoTaise20funmimanUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().setサービス提供責任者体制の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadServiceTeikyoSekininshaTaiseiUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set同一建物に居住する利用者の減算の有無(stringToCode(div.getJigyoshaServiceShosai()
                .getRadDoitsuTatemonoKyojuRiyoshaGenzanUmu().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set緊急短期入所体制確保加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKinkyuTankiNyushoTaiseiKakuhoKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set在宅復帰_在宅療養支援機能加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadZaitakuFukkiZaitakuRyoyoShienKinoKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set生活機能向上グループ活動加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadSeikatuKinoKojoGroupKatsudoKasan().getSelectedKey())).build();
        joho = joho.createBuilderForEdit().set介護職員処遇改善加算(stringToCode(div.getJigyoshaServiceShosai()
                .getRadKaigoShokuinShoguKaizenKasan().getSelectedKey())).build();
        return joho;
    }

    /**
     * 画面DDLの設定します。
     */
    public void set画面DDL() {
        set夜間勤務条件基準();
    }

    private void set夜間勤務条件基準() {
        List<UzT0007CodeEntity> codeJoho = CodeMaster.getCode(SubGyomuCode.DBZ介護共通, DBZCodeShubetsu.夜間勤務条件基準.getコード(), FlexibleDate.getNowDate());
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (UzT0007CodeEntity code : codeJoho) {
            KeyValueDataSource data = new KeyValueDataSource(code.getコード().getColumnValue(), code.getコード名称());
            dataSource.add(data);
        }
        div.getJigyoshaServiceShosai().getDdlYakanKinmuJokenKijun().setDataSource(dataSource);
    }

    private RString set介護事業者は基本情報に準拠(List<RString> selectKeys) {
        if (selectKeys.contains(準拠しない)) {
            return 準拠する;
        } else {
            return 準拠しない;
        }
    }

    private RString setRadio(Code code) {
        if (code == null) {
            return 無;
        } else if (!無.equals(code.getColumnValue())
                && !有.equals(code.getColumnValue())) {
            return 無;
        }
        return code.getColumnValue();
    }

    private RString set食事提供の状況DDL(Code code) {
        if (code == null) {
            return 無;
        } else if (!無.equals(code.getColumnValue())
                && !有.equals(code.getColumnValue())
                && !別表第二注２ロ該当.equals(code.getColumnValue())) {
            return 無;
        }
        return code.getColumnValue();
    }

    private RString set栄養管理の評価DDL(Code code) {
        if (code == null) {
            return 無;
        } else if (!無.equals(code.getColumnValue())
                && !有.equals(code.getColumnValue())
                && !別表第二注２ロ該当.equals(code.getColumnValue())
                && !栄養ケア_マネジメント体制.equals(code.getColumnValue())) {
            return 無;
        }
        return code.getColumnValue();
    }

    private Decimal intToDecimal(int data) {
        return new Decimal(data);
    }

    private int decimalToInt(Decimal data) {
        return data == null ? 0 : data.intValue();
    }

    private Code stringToCode(RString code) {
        return new Code(code);
    }

    private RString get保険者名(RString 保険者番号) {
        IHokenjaManager manager = new _HokenjaManager();
        Hokenja joho = manager.get保険者(new HokenjaNo(new RString("201501")), new HokenjaShubetsu(new RString("08")));
        if (joho != null) {
            return joho.get保険者名();
        }
        return RString.EMPTY;
    }
}
