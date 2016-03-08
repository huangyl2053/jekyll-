/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0410011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KokuhorenTorikomiJohoModel;
import jp.co.ndensan.reams.db.dbc.business.core.view.KokuhorenTorikomiJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysJukyushaDaichoJohoIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysJukyushaKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakugassanJikofutangakuShomeisho;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakugassanKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKohiJukyushabetsuIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyodoshoriJukyushaKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyufuJissekiKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyufuKanrihyo;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSaishinsaKetteiTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysShikakuShogohyo;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysShinsaKetteiSeikyuMeisai;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSogoJigyoSeikyugakuTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.ConfigKeysHenreiIchiranhyo;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.ConfigKeysJukyushaDaichoTotsugoKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.ConfigKeysKagoKetteiTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.ConfigKeysKyodoshoriJukyushaJohoIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.ConfigKeysSaishinsaKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.ConfigKeysSeikyugakuTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.ConfigKeysSogoJigyoKagoKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.enumeratedtype.ConfigKeysSogoJigyoShikakuShogohyo;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysFuSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKagoKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakuKyufuTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakuSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakugassanJikofutangakuKakunin;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakugassanSikyuKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSeikyugakuTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.IryoHokenRirekiManager;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.util.config.BusinessConfig;

/**
 * {@link KokuhorenTorikomiListDiv}のHandlerクラスです。
 */
public class KokuhorenTorikomiListHandler {

    private final KokuhorenTorikomiListDiv div;
    private final RString グリッドソート条件１ = new RString("ichiranHyojijun");
    private final int NUM = 8;

    /**
     * コンストラクタです。
     *
     * @param div 国保連取込リストDiv
     */
    public KokuhorenTorikomiListHandler(KokuhorenTorikomiListDiv div) {
        this.div = div;
    }

    /**
     * 処理年月テキストボックス変更時にリストを更新します。
     *
     * @param panel 国保連取込情報リストDiv
     * @param 処理年月 処理年月
     */
    public void load(KokuhorenTorikomiListDiv panel, RYearMonth 処理年月) {

        List<KokuhorenTorikomiJohoModel> kokuhorenTorikomiJohoList = new ArrayList<>();
        for (ConfigKeysKokuhorenTorikomi 交換識別番号 : ConfigKeysKokuhorenTorikomi.values()) {
            KokuhorenTorikomiJohoModel result = new KokuhorenTorikomiJohoModel();
            KokuhorenTorikomiJoho kokuhorenTorikomiJoho = IryoHokenRirekiManager.createInstance()
                    .getKokuhorenTorikomiJoho(new FlexibleYearMonth(処理年月.toDateString()), 交換識別番号.getコード());
            if (kokuhorenTorikomiJoho != null) {
                result.set国保連取込管理エンティティ(kokuhorenTorikomiJoho.toEntity());
                result = kokuhorenTorikomiConfigKeysFactory(result, 交換識別番号.getコード());
                result.set交換識別番号(交換識別番号.getコード());
                kokuhorenTorikomiJohoList.add(result);
            }
        }
        List<dgKokuhorenTorikomiList_Row> kokuhorenTorikomiListDataSource = new ArrayList<>();
        for (KokuhorenTorikomiJohoModel model : kokuhorenTorikomiJohoList) {
            kokuhorenTorikomiListDataSource.add(createKokuhorenTorikomiRow(model, 処理年月));
        }
        panel.getDgKokuhorenTorikomiList().setDataSource(kokuhorenTorikomiListDataSource);

        panel.getDgKokuhorenTorikomiList().setSortOrder(グリッドソート条件１);

    }

    private dgKokuhorenTorikomiList_Row createKokuhorenTorikomiRow(KokuhorenTorikomiJohoModel model, RYearMonth 処理年月) {
        dgKokuhorenTorikomiList_Row row = new dgKokuhorenTorikomiList_Row(RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY,
                RString.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, new TextBoxNum(), new TextBoxDate(), RString.EMPTY);
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(処理年月);
        rsb.append("_");
        rsb.append(model.get交換識別番号());
        if (SharedFile.searchSharedFile(rsb.toRString()).isEmpty()) {
            row.setTorikomiFlag(new RString("*"));
        } else {
            row.setTorikomiFlag(new RString(" "));
        }
        row.setTxtTorikomiJoho(model.get処理名());
        row.setTxtZenZengetsu(get処理状態(model.get前々月処理状態()));
        row.setTxtZengetsu(get処理状態(model.get前月処理状態()));
        if (model.get当月処理状態() != null && ShoriJotaiKubun.toValue(model.get当月処理状態()) != null) {
            row.setTxtTogetsuJotai(ShoriJotaiKubun.toValue(model.get当月処理状態()).get名称());
        }
        row.setTxtShoriNichiji(model.get当月処理日時() != null ? model.get当月処理日時().getDate().wareki().toDateString().concat(RString.FULL_SPACE)
                .concat(model.get当月処理日時().getRDateTime().getTime().toString().substring(0, NUM)) : RString.EMPTY);
        row.setSaishoriFlag(get再処理可否区分(model.get再処理可否区分()));
        row.getIchiranHyojijun().setValue(model.get一覧表示順() != null ? new Decimal(model.get一覧表示順().toString()) : Decimal.ZERO);
        row.setBatchID(model.getバッチID());
        row.setKokanShikibetsuNo(model.get交換識別番号());
        row.getShoriYM().setValue(new RDate(処理年月.getYearValue(), 処理年月.getMonthValue()));
        if (row.getTorikomiFlag().compareTo(" ") == 0 && (row.getTxtTogetsuJotai().compareTo("処理前") == 0)) {
            row.setSelectButtonState(DataGridButtonState.Enabled);
        } else {
            row.setSelectButtonState(DataGridButtonState.Disabled);
        }
        return row;
    }

    private RString get再処理可否区分(boolean 再処理可否) {
        if (再処理可否) {
            return new RString("再処理可能");
        } else {
            return new RString("再処理不可");
        }
    }

    private RString get処理状態(RString 処理状態区分) {

        if (処理状態区分 == null) {
            return new RString("");
        }

        switch (処理状態区分.toString()) {
            case "1":
                return new RString("×");
            case "3":
                return new RString("○");
            case "9":
                return new RString("-");
            default:
                return new RString("");
        }
    }

    private KokuhorenTorikomiJohoModel kokuhorenTorikomiConfigKeysFactory(KokuhorenTorikomiJohoModel result, RString 交換情報識別番号) {
        switch (交換情報識別番号.toString()) {
            case "111": // 受給者情報更新結果情報
                result.setバッチID(BusinessConfig.get(ConfigKeysJukyushaKoshinKekka.国保連取込_受給者情報更新結果情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysJukyushaKoshinKekka.国保連取込_受給者情報更新結果情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysJukyushaKoshinKekka.国保連取込_受給者情報更新結果情報_処理名称));
                return result;
            case "112": // 共同処理用受給者情報更新結果
                result.setバッチID(BusinessConfig.get(ConfigKeysKyodoshoriJukyushaKoshinKekka.国保連取込_共同処理用受給者情報更新結果_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKyodoshoriJukyushaKoshinKekka.国保連取込_共同処理用受給者情報更新結果_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKyodoshoriJukyushaKoshinKekka.国保連取込_共同処理用受給者情報更新結果_処理名称));
                return result;
            case "114": // 給付実績情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKyufuJisseki.国保連取込_給付実績情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKyufuJisseki.国保連取込_給付実績情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKyufuJisseki.国保連取込_給付実績情報_処理名称));
                return result;
            case "121": // 給付管理票情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKyufuKanrihyo.国保連取込_給付管理票情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKyufuKanrihyo.国保連取込_給付管理票情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKyufuKanrihyo.国保連取込_給付管理票情報_処理名称));
                return result;
            case "122": // 給付実績更新結果情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKyufuJissekiKoshinKekka.国保連取込_給付実績更新結果情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKyufuJissekiKoshinKekka.国保連取込_給付実績更新結果情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKyufuJissekiKoshinKekka.国保連取込_給付実績更新結果情報_処理名称));
                return result;
            case "151": // 介護給付費等審査決定請求明細表情報
                result.setバッチID(BusinessConfig.get(ConfigKeysShinsaKetteiSeikyuMeisai.国保連取込_介護給付費等審査決定請求明細表情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysShinsaKetteiSeikyuMeisai.国保連取込_介護給付費等審査決定請求明細表情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysShinsaKetteiSeikyuMeisai.国保連取込_介護給付費等審査決定請求明細表情報_処理名称));
                return result;
            case "152": // 介護給付費過誤決定通知書情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKagoKetteiTuchi.国保連取込_介護給付費過誤決定通知書情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKagoKetteiTuchi.国保連取込_介護給付費過誤決定通知書情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKagoKetteiTuchi.国保連取込_介護給付費過誤決定通知書情報_処理名称));
                return result;
            case "161": // 介護給付費再審査決定通知書情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSaishinsaKetteiTuchi.国保連取込_介護給付費再審査決定通知書情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSaishinsaKetteiTuchi.国保連取込_介護給付費再審査決定通知書情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSaishinsaKetteiTuchi.国保連取込_介護給付費再審査決定通知書情報_処理名称));
                return result;
            case "162": // 介護給付費等請求額通知書情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSeikyugakuTuchi.国保連取込_介護給付費等請求額通知書情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSeikyugakuTuchi.国保連取込_介護給付費等請求額通知書情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSeikyugakuTuchi.国保連取込_介護給付費等請求額通知書情報_処理名称));
                return result;
            case "171": // 介護給付費過誤決定通知書公費情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理名称));
                return result;
            case "172": // 介護給付費再審査決定通知書公費情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSaishinsaKetteiTuchi_Kohi.国保連取込_介護給付費再審査決定通知書公費情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSaishinsaKetteiTuchi_Kohi.国保連取込_介護給付費再審査決定通知書公費情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSaishinsaKetteiTuchi_Kohi.国保連取込_介護給付費再審査決定通知書公費情報_処理名称));
                return result;
            case "175": // 介護給付費等請求額通知書公費情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSeikyugakuTuchi_Kohi.国保連取込_介護給付費等請求額通知書公費情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSeikyugakuTuchi_Kohi.国保連取込_介護給付費等請求額通知書公費情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSeikyugakuTuchi_Kohi.国保連取込_介護給付費等請求額通知書公費情報_処理名称));
                return result;
            case "221": // 介護給付費公費受給者別一覧表情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKohiJukyushabetsuIchiran.国保連取込_介護給付費公費受給者別一覧表情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKohiJukyushabetsuIchiran.国保連取込_介護給付費公費受給者別一覧表情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKohiJukyushabetsuIchiran.国保連取込_介護給付費公費受給者別一覧表情報_処理名称));
                return result;
            case "222": // 償還払支給決定者一覧情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSikyuKetteishaIchiran.国保連取込_償還払支給決定者一覧情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSikyuKetteishaIchiran.国保連取込_償還払支給決定者一覧情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSikyuKetteishaIchiran.国保連取込_償還払支給決定者一覧情報_処理名称));
                return result;
            case "331": // 償還払不支給決定者一覧情報
                result.setバッチID(BusinessConfig.get(ConfigKeysFuSikyuKetteishaIchiran.国保連取込_償還払不支給決定者一覧情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysFuSikyuKetteishaIchiran.国保連取込_償還払不支給決定者一覧情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysFuSikyuKetteishaIchiran.国保連取込_償還払不支給決定者一覧情報_処理名称));
                return result;
            case "351": // 高額介護サービス費給付対象者一覧表情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKogakuKyufuTaishoshaIchiran.国保連取込_高額介護サービス費給付対象者一覧表情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKogakuKyufuTaishoshaIchiran.国保連取込_高額介護サービス費給付対象者一覧表情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKogakuKyufuTaishoshaIchiran.国保連取込_高額介護サービス費給付対象者一覧表情報_処理名称));
                return result;
            case "386": // 高額介護サービス費支給不支給決定者一覧表情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKogakuSikyuKetteishaIchiran.国保連取込_高額介護サービス費支給不支給決定者一覧表情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKogakuSikyuKetteishaIchiran.国保連取込_高額介護サービス費支給不支給決定者一覧表情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKogakuSikyuKetteishaIchiran.国保連取込_高額介護サービス費支給不支給決定者一覧表情報_処理名称));
                return result;
            case "533": // 受給者台帳情報一覧
                result.setバッチID(BusinessConfig.get(ConfigKeysJukyushaDaichoJohoIchiran.国保連取込_受給者台帳情報一覧_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysJukyushaDaichoJohoIchiran.国保連取込_受給者台帳情報一覧_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysJukyushaDaichoJohoIchiran.国保連取込_受給者台帳情報一覧_処理名称));
                return result;
            default:
                return kokuhorenTorikomiConfig(result, 交換情報識別番号);
        }
    }

    private KokuhorenTorikomiJohoModel kokuhorenTorikomiConfig(KokuhorenTorikomiJohoModel result, RString 交換情報識別番号) {
        switch (交換情報識別番号.toString()) {
            case "534": // 受給者台帳突合結果情報随時
                result.setバッチID(BusinessConfig.get(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理名称));
                return result;
            case "537": // 共同処理用受給者情報一覧
                result.setバッチID(BusinessConfig.get(ConfigKeysKyodoshoriJukyushaJohoIchiran.国保連取込_共同処理用受給者情報一覧_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKyodoshoriJukyushaJohoIchiran.国保連取込_共同処理用受給者情報一覧_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKyodoshoriJukyushaJohoIchiran.国保連取込_共同処理用受給者情報一覧_処理名称));
                return result;
            case "631": // 高額合算自己負担額確認情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKogakugassanJikofutangakuKakunin.国保連取込_高額合算自己負担額確認情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKogakugassanJikofutangakuKakunin.国保連取込_高額合算自己負担額確認情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKogakugassanJikofutangakuKakunin.国保連取込_高額合算自己負担額確認情報_処理名称));
                return result;
            case "641": // 高額合算自己負担額証明書情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKogakugassanJikofutangakuShomeisho.国保連取込_高額合算自己負担額証明書情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKogakugassanJikofutangakuShomeisho.国保連取込_高額合算自己負担額証明書情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKogakugassanJikofutangakuShomeisho.国保連取込_高額合算自己負担額証明書情報_処理名称));
                return result;
            case "651": // 高額合算支給額計算結果連絡票情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo.国保連取込_高額合算支給額計算結果連絡票情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo.国保連取込_高額合算支給額計算結果連絡票情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo.国保連取込_高額合算支給額計算結果連絡票情報_処理名称));
                return result;
            case "652": // 高額合算支給不支給決定通知書情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKogakugassanSikyuKetteiTuchi.国保連取込_高額合算支給不支給決定通知書情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKogakugassanSikyuKetteiTuchi.国保連取込_高額合算支給不支給決定通知書情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKogakugassanSikyuKetteiTuchi.国保連取込_高額合算支給不支給決定通知書情報_処理名称));
                return result;
            case "741": // 高額合算給付実績情報
                result.setバッチID(BusinessConfig.get(ConfigKeysKogakugassanKyufuJisseki.国保連取込_高額合算給付実績情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysKogakugassanKyufuJisseki.国保連取込_高額合算給付実績情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysKogakugassanKyufuJisseki.国保連取込_高額合算給付実績情報_処理名称));
                return result;
            case "37H": // 総合事業費過誤決定通知書情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSogoJigyoKagoKetteiTuchi.国保連取込_総合事業費過誤決定通知書情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSogoJigyoKagoKetteiTuchi.国保連取込_総合事業費過誤決定通知書情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSogoJigyoKagoKetteiTuchi.国保連取込_総合事業費過誤決定通知書情報_処理名称));
                return result;
            case "37J": // 総合事業費請求額通知書情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSogoJigyoSeikyugakuTuchi.国保連取込_総合事業費請求額通知書情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSogoJigyoSeikyugakuTuchi.国保連取込_総合事業費請求額通知書情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSogoJigyoSeikyugakuTuchi.国保連取込_総合事業費請求額通知書情報_処理名称));
                return result;
            case "38B": // 総合事業費審査決定請求明細表情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo.国保連取込_総合事業費審査決定請求明細表情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo.国保連取込_総合事業費審査決定請求明細表情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo.国保連取込_総合事業費審査決定請求明細表情報_処理名称));
                return result;
            case "38P": // 請求明細給付管理票返戻保留一覧表情報
                result.setバッチID(BusinessConfig.get(ConfigKeysHenreiIchiranhyo.国保連取込_請求明細給付管理票返戻保留一覧表情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysHenreiIchiranhyo.国保連取込_請求明細給付管理票返戻保留一覧表情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysHenreiIchiranhyo.国保連取込_請求明細給付管理票返戻保留一覧表情報_処理名称));
                return result;
            case "5C3": // 資格照合表情報
                result.setバッチID(BusinessConfig.get(ConfigKeysShikakuShogohyo.国保連取込_資格照合表情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysShikakuShogohyo.国保連取込_資格照合表情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysShikakuShogohyo.国保連取込_資格照合表情報_処理名称));
                return result;
            case "5C4": // 総合事業費資格照合表情報
                result.setバッチID(BusinessConfig.get(ConfigKeysSogoJigyoShikakuShogohyo.国保連取込_総合事業費資格照合表情報_バッチID));
                result.set一覧表示順(BusinessConfig.get(ConfigKeysSogoJigyoShikakuShogohyo.国保連取込_総合事業費資格照合表情報_一覧表示順));
                result.set処理名(BusinessConfig.get(ConfigKeysSogoJigyoShikakuShogohyo.国保連取込_総合事業費資格照合表情報_処理名称));
                return result;
            default:
                return result;
        }
    }

    public RString getParamter(RString 交換情報識別番号) {
        switch (交換情報識別番号.toString()) {
            case "111": // 受給者情報更新結果情報
                return new RString("26");
            case "112": // 共同処理用受給者情報更新結果
                return new RString("18");
            case "114": // 給付実績情報
                return new RString("39");
            case "121": // 給付管理票情報
                return new RString("19");
            case "122": // 給付実績更新結果情報
                return new RString("27");
            case "151": // 介護給付費等審査決定請求明細表情報
                return new RString("20");
            case "152": // 介護給付費過誤決定通知書情報
                return new RString("21");
            case "161": // 介護給付費再審査決定通知書情報
                return new RString("22");
            case "162": // 介護給付費等請求額通知書情報
                return new RString("12");
            case "171": // 介護給付費過誤決定通知書公費情報
                return new RString("23");
            case "172": // 介護給付費再審査決定通知書公費情報
                return new RString("24");
            case "175": // 介護給付費等請求額通知書公費情報
                return new RString("14");
            case "221": // 介護給付費公費受給者別一覧表情報
                return new RString("25");
            case "222": // 償還払支給決定者一覧情報
                return new RString("28");
            case "331": // 償還払不支給決定者一覧情報
                return new RString("29");
            case "351": // 高額介護サービス費給付対象者一覧表情報
                return new RString("30");
            case "386": // 高額介護サービス費支給不支給決定者一覧表情報
                return new RString("31");
            case "533": // 受給者台帳情報一覧
                return new RString("");
            case "534": // 受給者台帳突合結果情報随時
                return new RString("");
            case "537": // 共同処理用受給者情報一覧
                return new RString("");
            case "631": // 高額合算自己負担額確認情報
                return new RString("32");
            case "641": // 高額合算自己負担額証明書情報
                return new RString("33");
            case "651": // 高額合算支給額計算結果連絡票情報
                return new RString("34");
            case "652": // 高額合算支給不支給決定通知書情報
                return new RString("35");
            case "741": // 高額合算給付実績情報
                return new RString("36");
            case "37H": // 総合事業費過誤決定通知書情報
                return new RString("37");
            case "37J": // 総合事業費請求額通知書情報
                return new RString("13");
            case "38B": // 総合事業費審査決定請求明細表情報
                return new RString("38");
            case "38P": // 請求明細給付管理票返戻保留一覧表情報
                return new RString("15");
            case "5C3": // 資格照合表情報
                return new RString("16");
            case "5C4": // 総合事業費資格照合表情報
                return new RString("");
            default:
                return new RString("");
        }
    }
}
