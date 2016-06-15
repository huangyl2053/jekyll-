/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC0300012;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JuryoininKeiyakuJigyoshaBuilder;
import jp.co.ndensan.reams.db.dbc.definition.core.keiyakushurui.JuryoIninKeiyakuShurui;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0300012.PnlTotalRegisterDiv;
import jp.co.ndensan.reams.db.dbc.service.core.basic.JuryoininKeiyakuJigyoshaManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.biz.KinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;
import jp.co.ndensan.reams.uz.uza.util.code.CodeMaster;
import jp.co.ndensan.reams.uz.uza.util.code.entity.UzT0007CodeEntity;

/**
 * 償還払い状況照会_申請情報検索のHandlerクラス
 *
 * @reamsid_L DBC-2120-020 panhe
 */
public final class PnlTotalRegisterHandler {

    private final PnlTotalRegisterDiv div;
    private static final RString 参照 = new RString("参照");
    private static final RString 修正 = new RString("修正");
    private static final RString 削除 = new RString("削除");
    private static final RString 登録 = new RString("登録");
    private static final RString 保存する = new RString("Element3");
    private static final RString 預金種別コード = new RString("0085");

    /**
     * コンストラクタです。
     *
     * @param div PtnTotalRegisterDiv
     */
    private PnlTotalRegisterHandler(PnlTotalRegisterDiv div) {
        this.div = div;
    }

    /**
     * 初期化メソッド
     *
     * @param div PtnTotalRegisterDiv
     * @return PnlTotalRegisterHandler
     */
    public static PnlTotalRegisterHandler of(PnlTotalRegisterDiv div) {
        return new PnlTotalRegisterHandler(div);
    }

    /**
     * 初期化データの設定
     *
     * @param 処理モード RString
     * @param record JuryoininKeiyakuJigyosha
     */
    public void set初期データ(RString 処理モード, JuryoininKeiyakuJigyosha record) {

        div.getPnlKeyakuJigyosya().getTxtJigyosyakeiyakuNo().setValue(record.get契約事業者番号());
        RDate 開始年月日RDate = RDate.canConvert(new RString(record.get開始年月日().toString()))
                ? new RDate(record.get開始年月日().toString()) : null;
        div.getPnlKeyakuJigyosya().getTxtKeyakubi().setFromValue(開始年月日RDate);
        RDate 終了年月日RDate = RDate.canConvert(new RString(record.get終了年月日().toString()))
                ? new RDate(record.get終了年月日().toString()) : null;
        div.getPnlKeyakuJigyosya().getTxtKeyakubi().setToValue(終了年月日RDate);

        List<KeyValueDataSource> keiyakuSyuruList = new ArrayList<>();
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.住宅改修.getコード(), JuryoIninKeiyakuShurui.住宅改修.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.福祉用具.getコード(), JuryoIninKeiyakuShurui.福祉用具.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.住宅改修_福祉用具.getコード(), JuryoIninKeiyakuShurui.住宅改修_福祉用具.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.償還払給付.getコード(), JuryoIninKeiyakuShurui.償還払給付.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.高額給付費.getコード(), JuryoIninKeiyakuShurui.高額給付費.get名称()));
        div.getPnlKeyakuJigyosya().getDdlKeyakusyurui().setDataSource(keiyakuSyuruList);
        div.getPnlKeyakuJigyosya().getDdlKeyakusyurui().setSelectedKey(record.get契約種類());
        div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo().setDomain(record.get契約事業者名称());
        div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana().setDomain(record.get契約事業者カナ名称());
        div.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo().setValue(record.get契約事業者郵便番号());
        div.getPnlKeyakuJigyosya().getTxtJigyosyaTel().setDomain(record.get契約事業者電話番号());
        div.getPnlKeyakuJigyosya().getTxtJigyosyaFax().setDomain(record.get契約事業者FAX番号());
        div.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo().setDomain(record.get契約事業者住所());
        div.getPnlKeyakuJigyosya().getTxtSofusakiYubin().setValue(record.get送付先郵便番号());
        div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya().setDomain(record.get送付先事業者名称());
        div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana().setDomain(record.get送付先事業者カナ名称());
        div.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo().setDomain(record.get送付先住所());
        div.getPnlKeyakuJigyosya().getTxtSofusakiBusyo().setValue(record.get送付先部署());
        div.getPnlKeyakuJigyosya().getCcdKinyukikan().search(record.get金融機関コード(),
                record.get支店コード(), FlexibleDate.getNowDate());
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                new CodeShubetsu(預金種別コード), FlexibleDate.getNowDate());
        List<KeyValueDataSource> keyValueDataSource = new ArrayList<>();
        if (codeList != null && !codeList.isEmpty()) {
            for (UzT0007CodeEntity code : codeList) {
                keyValueDataSource.add(new KeyValueDataSource(code.getコード().getColumnValue(), code.getコード名称()));
            }
            div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().setDataSource(keyValueDataSource);
            div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().setSelectedKey(record.get口座種別());
        } else {
            div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().setDataSource(keyValueDataSource);
        }
        if (div.getPnlKeyakuJigyosya().getCcdKinyukikan().isゆうちょ銀行()) {
            div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().setVisible(false);
        }
        div.getPnlKeyakuJigyosya().getTxtSofusakiKouzabango().setValue(record.get口座番号());
        div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeiginin().setDomain(record.get口座名義人());
        div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeigininKana().setDomain(record.get口座名義人カナ());
        if (参照.equals(処理モード)) {
            set項目非活性();
            CommonButtonHolder.setDisplayNoneByCommonButtonFieldName(保存する, true);
        } else if (削除.equals(処理モード)) {
            set項目非活性();
        }
    }

    /**
     * getRecord
     *
     * @param data JuryoininKeiyakuJigyosha
     * @return JuryoininKeiyakuJigyosha
     */
    public JuryoininKeiyakuJigyosha getRecord(JuryoininKeiyakuJigyosha data) {
        JuryoininKeiyakuJigyosha record = JuryoininKeiyakuJigyoshaManager.createInstance()
                .getJuryoininKeiyakuJigyosha(data.get契約事業者番号(), data.get開始年月日(), data.get終了年月日());
        if (record == null) {
            throw new ApplicationException(UrErrorMessages.データが存在しない.getMessage());
        }
        return record;
    }

    /**
     * 画面データの保存
     *
     * @param 処理モード RString
     * @param data JuryoininKeiyakuJigyosha
     * @return int
     */
    public int save画面データ(RString 処理モード, JuryoininKeiyakuJigyosha data) {
        if (修正.equals(処理モード)) {
            data = get画面データ(data);
            return JuryoininKeiyakuJigyoshaManager.createInstance().updJuryoininKeiyakuJigyosha(data);
        } else if (削除.equals(処理モード)) {
            return JuryoininKeiyakuJigyoshaManager.createInstance().delJuryoininKeiyakuJigyosha(data);
        } else {
            JuryoininKeiyakuJigyosha insertData = new JuryoininKeiyakuJigyosha(RString.EMPTY);
            JuryoininKeiyakuJigyoshaBuilder builder = insertData.createBuilderForEdit();
            builder.set開始年月日(new FlexibleDate(div.getPnlKeyakuJigyosya().getTxtKeyakubi().getFromValue().toDateString()));
            builder.set終了年月日(new FlexibleDate(div.getPnlKeyakuJigyosya().getTxtKeyakubi().getToValue().toDateString()));
            builder.set契約種類(div.getPnlKeyakuJigyosya().getDdlKeyakusyurui().getSelectedKey());
            builder.set契約事業者名称(div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo().getDomain());
            builder.set契約事業者カナ名称(div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana().getDomain());
            builder.set契約事業者郵便番号(div.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo().getValue());
            builder.set契約事業者住所(div.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo().getDomain());
            builder.set契約事業者電話番号(div.getPnlKeyakuJigyosya().getTxtJigyosyaTel().getDomain());
            builder.set契約事業者FAX番号(div.getPnlKeyakuJigyosya().getTxtJigyosyaFax().getDomain());
            builder.set送付先郵便番号(div.getPnlKeyakuJigyosya().getTxtSofusakiYubin().getValue());
            builder.set送付先住所(div.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo().getDomain());
            builder.set送付先部署(div.getPnlKeyakuJigyosya().getTxtSofusakiBusyo().getValue());
            builder.set送付先事業者名称(div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya().getDomain());
            builder.set送付先事業者カナ名称(div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana().getDomain());
            builder.set金融機関コード(div.getPnlKeyakuJigyosya().getCcdKinyukikan().getKinyuKikanCode());
            builder.set支店コード(div.getPnlKeyakuJigyosya().getCcdKinyukikan().getKinyuKikanShitenCode());
            builder.set口座種別(div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().getSelectedKey());
            builder.set口座番号(div.getPnlKeyakuJigyosya().getTxtSofusakiKouzabango().getValue());
            builder.set口座名義人(div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeiginin().getDomain());
            builder.set口座名義人カナ(div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeigininKana().getDomain());
            insertData = builder.build();
            return JuryoininKeiyakuJigyoshaManager.createInstance().insJuryoininKeiyakuJigyosha(insertData);
        }
    }

    /**
     * 保存完了画面の入替
     *
     * @param 処理モード RString
     * @param result int
     */
    public void set保存完了(RString 処理モード, int result) {
        if (削除.equals(処理モード)) {
            div.getPnlHakoubi().setDisplayNone(true);
        }
        if (result > 0) {
            div.getCcdKaigoKanryoMessage().setMessage(UrInformationMessages.保存終了, RString.EMPTY, RString.EMPTY, true);
        } else {
            div.getCcdKaigoKanryoMessage().setMessage(UrInformationMessages.保存終了, RString.EMPTY, RString.EMPTY, false);
        }
    }

    /**
     * 画面データ変更有無の判定
     *
     * @param 処理モード RString
     * @param param JuryoininKeiyakuJigyosha
     * @return boolean
     */
    public boolean has画面変更有無(RString 処理モード, JuryoininKeiyakuJigyosha param) {
        if (登録.equals(処理モード)) {
            return has契約登録情報有無() || has送付登録情報有無();
        }
        if (!修正.equals(処理モード)) {
            return false;
        }
        if (!param.get契約事業者番号().equals(div.getPnlKeyakuJigyosya().getTxtJigyosyakeiyakuNo().getValue())) {
            return true;
        }

        if (has契約情報変更有無(param)) {
            return true;
        }

        return has送付情報変更有無1(param) || has送付情報変更有無2(param);
    }

    /**
     * 契約登録情報有無の判定
     *
     * @return boolean
     */
    private boolean has契約登録情報有無() {
        return div.getPnlKeyakuJigyosya().getTxtKeyakubi().getFromValue() != null
                || div.getPnlKeyakuJigyosya().getTxtKeyakubi().getToValue() != null
                || !div.getPnlKeyakuJigyosya().getDdlKeyakusyurui().getSelectedKey().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo().getDomain().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana().getDomain().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo().getValue().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtJigyosyaTel().getDomain().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtJigyosyaFax().getDomain().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo().getDomain().isEmpty();
    }

    /**
     * 送付登録情報有無の判定
     *
     * @return boolean
     */
    private boolean has送付登録情報有無() {
        return !div.getPnlKeyakuJigyosya().getTxtSofusakiYubin().getValue().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya().getDomain().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana().getDomain().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo().getDomain().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtSofusakiBusyo().getValue().isEmpty()
                || !div.getPnlKeyakuJigyosya().getCcdKinyukikan().getKinyuKikanCode().isEmpty()
                || !div.getPnlKeyakuJigyosya().getCcdKinyukikan().getKinyuKikanShitenCode().isEmpty()
                || !div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().getSelectedKey().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtSofusakiKouzabango().getValue().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeiginin().getDomain().isEmpty()
                || !div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeigininKana().getDomain().isEmpty();
    }

    /**
     * 契約情報変更有無の判定
     *
     * @param param JuryoininKeiyakuJigyosha
     * @return boolean
     */
    private boolean has契約情報変更有無(JuryoininKeiyakuJigyosha param) {
        FlexibleDate txtKeyakubiFrom = new FlexibleDate(div.getPnlKeyakuJigyosya().getTxtKeyakubi().getFromValue().toDateString());
        FlexibleDate txtKeyakubiTo = new FlexibleDate(div.getPnlKeyakuJigyosya().getTxtKeyakubi().getToValue().toDateString());
        RString keyakusyurui = div.getPnlKeyakuJigyosya().getDdlKeyakusyurui().getSelectedKey();
        AtenaMeisho keyakuJigyosyaMeisyo = div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo().getDomain();
        AtenaKanaMeisho keyakuJigyosyaMeisyoKana = div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana().getDomain();
        YubinNo txtJigyosyaYubinNo = div.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo().getValue();
        TelNo txtJigyosyaTel = div.getPnlKeyakuJigyosya().getTxtJigyosyaTel().getDomain();
        TelNo txtJigyosyaFax = div.getPnlKeyakuJigyosya().getTxtJigyosyaFax().getDomain();
        AtenaJusho txtJigyosyaJyusyo = div.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo().getDomain();
        return !param.get開始年月日().equals(txtKeyakubiFrom)
                || !param.get終了年月日().equals(txtKeyakubiTo)
                || !param.get契約種類().equals(keyakusyurui)
                || !(param.get契約事業者名称() == null ? AtenaMeisho.EMPTY : param.get契約事業者名称()).equals(keyakuJigyosyaMeisyo)
                || !(param.get契約事業者カナ名称() == null ? AtenaKanaMeisho.EMPTY : param.get契約事業者カナ名称())
                .equals(keyakuJigyosyaMeisyoKana)
                || !(param.get契約事業者郵便番号() == null ? YubinNo.EMPTY : param.get契約事業者郵便番号()).equals(txtJigyosyaYubinNo)
                || !(param.get契約事業者電話番号() == null ? TelNo.EMPTY : param.get契約事業者電話番号()).equals(txtJigyosyaTel)
                || !(param.get契約事業者FAX番号() == null ? TelNo.EMPTY : param.get契約事業者FAX番号()).equals(txtJigyosyaFax)
                || !(param.get契約事業者住所() == null ? AtenaJusho.EMPTY : param.get契約事業者住所()).equals(txtJigyosyaJyusyo);
    }

    /**
     * 送付情報変更有無1
     *
     * @param param JuryoininKeiyakuJigyosha
     * @return boolean
     */
    private boolean has送付情報変更有無1(JuryoininKeiyakuJigyosha param) {
        YubinNo txtSofusakiYubin = div.getPnlKeyakuJigyosya().getTxtSofusakiYubin().getValue();
        AtenaMeisho txtSofusakiJigyosya = div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya().getDomain();
        AtenaKanaMeisho txtSofusakiJigyosyaKana = div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana().getDomain();
        AtenaJusho txtSofusakiJyusyo = div.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo().getDomain();
        RString txtSofusakiBusyo = div.getPnlKeyakuJigyosya().getTxtSofusakiBusyo().getValue();
        return !(param.get送付先郵便番号() == null ? YubinNo.EMPTY : param.get送付先郵便番号()).equals(txtSofusakiYubin)
                || !(param.get送付先事業者名称() == null ? AtenaMeisho.EMPTY : param.get送付先事業者名称()).equals(txtSofusakiJigyosya)
                || !(param.get送付先事業者カナ名称() == null ? AtenaKanaMeisho.EMPTY : param.get送付先事業者カナ名称())
                .equals(txtSofusakiJigyosyaKana)
                || !(param.get送付先住所() == null ? AtenaJusho.EMPTY : param.get送付先住所()).equals(txtSofusakiJyusyo)
                || !(param.get送付先部署() == null ? RString.EMPTY : param.get送付先部署()).equals(txtSofusakiBusyo);
    }

    /**
     * 送付情報変更有無2
     *
     * @param param JuryoininKeiyakuJigyosha
     * @return boolean
     */
    private boolean has送付情報変更有無2(JuryoininKeiyakuJigyosha param) {
        KinyuKikanCode kinyuKikanCode = div.getPnlKeyakuJigyosya().getCcdKinyukikan().getKinyuKikanCode();
        KinyuKikanShitenCode kinyuKikanShitenCode = div.getPnlKeyakuJigyosya().getCcdKinyukikan().getKinyuKikanShitenCode();
        RString sofusakiKouzasyubetu = div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().getSelectedKey();
        RString txtSofusakiKouzabango = div.getPnlKeyakuJigyosya().getTxtSofusakiKouzabango().getValue();
        AtenaMeisho txtSofusakiKouzaMeiginin = div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeiginin().getDomain();
        AtenaKanaMeisho txtSofusakiKouzaMeigininKana = div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeigininKana().getDomain();
        return !param.get金融機関コード().equals(kinyuKikanCode)
                || !param.get支店コード().equals(kinyuKikanShitenCode)
                || !(param.get口座種別() == null ? RString.EMPTY : param.get口座種別()).equals(sofusakiKouzasyubetu)
                || !(param.get口座番号() == null ? RString.EMPTY : param.get口座番号()).equals(txtSofusakiKouzabango)
                || !(param.get口座名義人() == null ? AtenaMeisho.EMPTY : param.get口座名義人()).equals(txtSofusakiKouzaMeiginin)
                || !(param.get口座名義人カナ() == null ? AtenaKanaMeisho.EMPTY : param.get口座名義人カナ())
                .equals(txtSofusakiKouzaMeigininKana);
    }

    /**
     * 画面データの取得
     *
     * @param param JuryoininKeiyakuJigyosha
     * @return JuryoininKeiyakuJigyosha
     */
    private JuryoininKeiyakuJigyosha get画面データ(JuryoininKeiyakuJigyosha param) {
        param = param.createBuilderForEdit()
                .set契約事業者番号(div.getPnlKeyakuJigyosya().getTxtJigyosyakeiyakuNo().getValue())
                .set開始年月日(
                        new FlexibleDate(div.getPnlKeyakuJigyosya().getTxtKeyakubi().getFromValue().toDateString()))
                .set終了年月日(
                        new FlexibleDate(div.getPnlKeyakuJigyosya().getTxtKeyakubi().getToValue().toDateString()))
                .set契約種類(div.getPnlKeyakuJigyosya().getDdlKeyakusyurui().getSelectedKey())
                .set契約事業者名称(div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo().getDomain())
                .set契約事業者カナ名称(div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana().getDomain())
                .set契約事業者郵便番号(div.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo().getValue())
                .set契約事業者電話番号(div.getPnlKeyakuJigyosya().getTxtJigyosyaTel().getDomain())
                .set契約事業者FAX番号(div.getPnlKeyakuJigyosya().getTxtJigyosyaFax().getDomain())
                .set契約事業者住所(div.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo().getDomain())
                .set送付先郵便番号(div.getPnlKeyakuJigyosya().getTxtSofusakiYubin().getValue())
                .set送付先事業者名称(div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya().getDomain())
                .set送付先事業者カナ名称(div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana().getDomain())
                .set送付先住所(div.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo().getDomain())
                .set送付先部署(div.getPnlKeyakuJigyosya().getTxtSofusakiBusyo().getValue())
                .set金融機関コード(div.getPnlKeyakuJigyosya().getCcdKinyukikan().getKinyuKikanCode())
                .set支店コード(div.getPnlKeyakuJigyosya().getCcdKinyukikan().getKinyuKikanShitenCode())
                .set口座種別(div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().getSelectedKey())
                .set口座番号(div.getPnlKeyakuJigyosya().getTxtSofusakiKouzabango().getValue())
                .set口座名義人(div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeiginin().getDomain())
                .set口座名義人カナ(div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeigininKana().getDomain()).build();
        return param;
    }

    /**
     * 登録初期データの設定
     */
    public void set登録初期データ() {
        div.getPnlKeyakuJigyosya().getTxtJigyosyakeiyakuNo().clearValue();
        div.getPnlKeyakuJigyosya().getTxtJigyosyakeiyakuNo().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtKeyakubi().clearFromValue();
        div.getPnlKeyakuJigyosya().getTxtKeyakubi().clearToValue();
        List<KeyValueDataSource> keiyakuSyuruList = new ArrayList<>();
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.住宅改修.getコード(), JuryoIninKeiyakuShurui.住宅改修.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.福祉用具.getコード(), JuryoIninKeiyakuShurui.福祉用具.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.住宅改修_福祉用具.getコード(), JuryoIninKeiyakuShurui.住宅改修_福祉用具.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.償還払給付.getコード(), JuryoIninKeiyakuShurui.償還払給付.get名称()));
        keiyakuSyuruList.add(new KeyValueDataSource(
                JuryoIninKeiyakuShurui.高額給付費.getコード(), JuryoIninKeiyakuShurui.高額給付費.get名称()));
        div.getPnlKeyakuJigyosya().getDdlKeyakusyurui().setDataSource(keiyakuSyuruList);
        div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo().clearDomain();
        div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana().clearDomain();
        div.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo().clearValue();
        div.getPnlKeyakuJigyosya().getTxtJigyosyaTel().clearDomain();
        div.getPnlKeyakuJigyosya().getTxtJigyosyaFax().clearDomain();
        div.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo().clearDomain();
        div.getPnlKeyakuJigyosya().getTxtSofusakiYubin().clearValue();
        div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya().clearDomain();
        div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana().clearDomain();
        div.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo().clearDomain();
        div.getPnlKeyakuJigyosya().getTxtSofusakiBusyo().clearValue();
        List<UzT0007CodeEntity> codeList = CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系,
                new CodeShubetsu(預金種別コード), FlexibleDate.getNowDate());
        List<KeyValueDataSource> keyValueDataSource = new ArrayList<>();
        if (codeList != null && !codeList.isEmpty()) {
            for (UzT0007CodeEntity code : codeList) {
                keyValueDataSource.add(new KeyValueDataSource(code.getコード().getColumnValue(), code.getコード名称()));
            }
            div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().setIsBlankLine(true);
        }
        div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().setDataSource(keyValueDataSource);
        if (div.getPnlKeyakuJigyosya().getCcdKinyukikan().isゆうちょ銀行()) {
            div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().setVisible(false);
        }
    }

    /**
     * 非活性項目の設定
     */
    private void set項目非活性() {
        div.getPnlKeyakuJigyosya().getBtnCopy().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtJigyosyakeiyakuNo().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtKeyakubi().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtKeyakubi().setDisabled(true);
        div.getPnlKeyakuJigyosya().getDdlKeyakusyurui().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtJigyosyaTel().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtJigyosyaFax().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtSofusakiYubin().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtSofusakiBusyo().setDisabled(true);
        div.getPnlKeyakuJigyosya().getCcdKinyukikan().setDisabled(true);
        div.getPnlKeyakuJigyosya().getDdlSofusakiKouzasyubetu().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtSofusakiKouzabango().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeiginin().setDisabled(true);
        div.getPnlKeyakuJigyosya().getTxtSofusakiKouzaMeigininKana().setDisabled(true);
    }

    /**
     * 画面データの複製
     */
    public void copy画面データ() {
        div.getPnlKeyakuJigyosya().getTxtSofusakiYubin().setValue(
                div.getPnlKeyakuJigyosya().getTxtJigyosyaYubinNo().getValue());
        div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosya().setDomain(
                div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyo().getDomain());
        div.getPnlKeyakuJigyosya().getTxtSofusakiJigyosyaKana().setDomain(
                div.getPnlKeyakuJigyosya().getTxtKeyakuJigyosyaMeisyoKana().getDomain());
        div.getPnlKeyakuJigyosya().getTxtSofusakiJyusyo().setDomain(
                div.getPnlKeyakuJigyosya().getTxtJigyosyaJyusyo().getDomain());
    }
}
