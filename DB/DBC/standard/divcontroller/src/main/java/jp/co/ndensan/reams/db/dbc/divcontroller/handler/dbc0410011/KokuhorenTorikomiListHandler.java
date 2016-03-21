/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.dbc0410011;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.KokuhorenTorikomiJohoInfo;
import jp.co.ndensan.reams.db.dbc.business.core.view.KokuhorenTorikomiJoho;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysFuSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysHenreiIchiranhyo;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysJukyushaDaichoJohoIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysJukyushaDaichoTotsugoKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysJukyushaKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKagoKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKagoKetteiTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakuKyufuTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakuSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakugassanJikofutangakuKakunin;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakugassanJikofutangakuShomeisho;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakugassanKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakugassanSikyuKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKohiJukyushabetsuIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyodoshoriJukyushaJohoIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyodoshoriJukyushaKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyufuJissekiKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysKyufuKanrihyo;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSaishinsaKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSaishinsaKetteiTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSeikyugakuTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSeikyugakuTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysShikakuShogohyo;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysShinsaKetteiSeikyuMeisai;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSogoJigyoKagoKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSogoJigyoSeikyugakuTuchi;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSogoJigyoShikakuShogohyo;
import jp.co.ndensan.reams.db.dbc.definition.core.configkeys.ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo;
import jp.co.ndensan.reams.db.dbc.definition.core.kokuhoreninterface.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.KokuhorenTorikomiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.db.dbc.service.core.basic.IryoHokenRirekiManager;
import jp.co.ndensan.reams.db.dbx.service.core.dbbusinessconfig.DbBusinessConifg;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;

/**
 * {@link KokuhorenTorikomiListDiv}のHandlerクラスです。
 */
public class KokuhorenTorikomiListHandler {

    private final KokuhorenTorikomiListDiv div;
    private static final RString グリッドソート条件１ = new RString("ichiranHyojijun");
    private static final int NUM = 8;
    private static final RString 再処理可能 = new RString("再処理可能");
    private static final RString 再処理不可 = new RString("再処理不可");
    private static final RString 処理前 = new RString("処理前");
    private static final RString アンダーライン = new RString("_");
    private static final RString アステリスク = new RString("*");
    private static final RString 処理状態区分_フォーク = new RString("×");
    private static final RString 処理状態区分_丸い = new RString("○");
    private static final RString 処理状態区分_横線 = new RString("-");

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
     * @param 処理年月 RYearMonth
     */
    public void load(RYearMonth 処理年月) {
        List<KokuhorenTorikomiJohoInfo> kokuhorenTorikomiJohoList = new ArrayList<>();
        for (ConfigKeysKokuhorenTorikomi 交換識別番号 : ConfigKeysKokuhorenTorikomi.values()) {
            KokuhorenTorikomiJohoInfo result = new KokuhorenTorikomiJohoInfo();
            KokuhorenTorikomiJoho kokuhorenTorikomiJoho = IryoHokenRirekiManager.createInstance()
                    .getKokuhorenTorikomiJoho(new FlexibleYearMonth(処理年月.toDateString()), 交換識別番号.getコード());
            if (kokuhorenTorikomiJoho != null) {
                result.set国保連取込管理エンティティ(kokuhorenTorikomiJoho.toEntity());
                result = set隠し項目(result, 交換識別番号.getコード());
                result.set交換識別番号(交換識別番号.getコード());
                kokuhorenTorikomiJohoList.add(result);
            }
        }
        List<dgKokuhorenTorikomiList_Row> kokuhorenTorikomiListDataSource = new ArrayList<>();
        for (KokuhorenTorikomiJohoInfo model : kokuhorenTorikomiJohoList) {
            kokuhorenTorikomiListDataSource.add(createKokuhorenTorikomiRow(model, 処理年月));
        }
        div.getDgKokuhorenTorikomiList().setDataSource(kokuhorenTorikomiListDataSource);
        div.getDgKokuhorenTorikomiList().setSortOrder(グリッドソート条件１);
    }

    private dgKokuhorenTorikomiList_Row createKokuhorenTorikomiRow(
            KokuhorenTorikomiJohoInfo model,
            RYearMonth 処理年月) {
        dgKokuhorenTorikomiList_Row row = new dgKokuhorenTorikomiList_Row();
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(処理年月);
        rsb.append(アンダーライン);
        rsb.append(model.get交換識別番号());
        if (SharedFile.searchSharedFile(rsb.toRString()).isEmpty()) {
            row.setTorikomiFlag(アステリスク);
        } else {
            row.setTorikomiFlag(RString.FULL_SPACE);
        }
        row.setTxtTorikomiJoho(model.get処理名());
        row.setTxtZenZengetsu(get処理状態(model.get前々月処理状態()));
        row.setTxtZengetsu(get処理状態(model.get前月処理状態()));
        if (model.get当月処理状態() != null && ShoriJotaiKubun.toValue(model.get当月処理状態()) != null) {
            row.setTxtTogetsuJotai(ShoriJotaiKubun.toValue(model.get当月処理状態()).get名称());
        }
        row.setTxtShoriNichiji(model.get当月処理日時() != null ? model.get当月処理日時().getDate()
                .wareki().toDateString().concat(RString.FULL_SPACE)
                .concat(model.get当月処理日時().getRDateTime().getTime().toString().substring(0, NUM)) : RString.EMPTY);
        row.setSaishoriFlag(get再処理可否区分(model.get再処理可否区分()));
        row.getIchiranHyojijun().setValue(model.get一覧表示順() != null ? new Decimal(model.get一覧表示順().toString())
                : Decimal.ZERO);
        row.setBatchID(model.getバッチID());
        row.setKokanShikibetsuNo(model.get交換識別番号());
        row.getShoriYM().setValue(new RDate(処理年月.getYearValue(), 処理年月.getMonthValue()));
        if (row.getTorikomiFlag().compareTo(RString.HALF_SPACE) == 0
                && (row.getTxtTogetsuJotai().compareTo(処理前) == 0)) {
            row.setSelectButtonState(DataGridButtonState.Enabled);
        } else {
            row.setSelectButtonState(DataGridButtonState.Disabled);
        }
        return row;
    }

    private RString get再処理可否区分(boolean 再処理可否) {
        if (再処理可否) {
            return 再処理可能;
        } else {
            return 再処理不可;
        }
    }

    private RString get処理状態(RString 処理状態区分) {

        if (処理状態区分 == null) {
            return RString.EMPTY;
        }

        switch (処理状態区分.toString()) {
            case "1":
                return 処理状態区分_フォーク;
            case "3":
                return 処理状態区分_丸い;
            case "9":
                return 処理状態区分_横線;
            default:
                return RString.EMPTY;
        }
    }

    private KokuhorenTorikomiJohoInfo set隠し項目(
            KokuhorenTorikomiJohoInfo result,
            RString 交換情報識別番号) {
        RDate date = RDate.getNowDate();
        switch (交換情報識別番号.toString()) {
            case "111":
                result.setバッチID(DbBusinessConifg.get(ConfigKeysKyufuJisseki.国保連取込_給付実績情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(ConfigKeysKyufuJisseki.国保連取込_給付実績情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(ConfigKeysKyufuJisseki.国保連取込_給付実績情報_処理名称, date));
                return result;
            case "112":
                result.setバッチID(DbBusinessConifg.get(ConfigKeysKyufuKanrihyo.国保連取込_給付管理票情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(ConfigKeysKyufuKanrihyo.国保連取込_給付管理票情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(ConfigKeysKyufuKanrihyo.国保連取込_給付管理票情報_処理名称, date));
                return result;
            case "114":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKyufuJissekiKoshinKekka.国保連取込_給付実績更新結果情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKyufuJissekiKoshinKekka.国保連取込_給付実績更新結果情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKyufuJissekiKoshinKekka.国保連取込_給付実績更新結果情報_処理名称, date));
                return result;
            case "121":
                result.setバッチID(DbBusinessConifg.get(ConfigKeysShikakuShogohyo.国保連取込_資格照合表情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(ConfigKeysShikakuShogohyo.国保連取込_資格照合表情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(ConfigKeysShikakuShogohyo.国保連取込_資格照合表情報_処理名称, date));
                return result;
            case "122":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoShikakuShogohyo.国保連取込_総合事業費資格照合表情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoShikakuShogohyo.国保連取込_総合事業費資格照合表情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoShikakuShogohyo.国保連取込_総合事業費資格照合表情報_処理名称, date));
                return result;
            case "151":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSeikyugakuTuchi.国保連取込_介護給付費等請求額通知書情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSeikyugakuTuchi.国保連取込_介護給付費等請求額通知書情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSeikyugakuTuchi.国保連取込_介護給付費等請求額通知書情報_処理名称, date));
                return result;
            case "152":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoSeikyugakuTuchi.国保連取込_総合事業費請求額通知書情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoSeikyugakuTuchi.国保連取込_総合事業費請求額通知書情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoSeikyugakuTuchi.国保連取込_総合事業費請求額通知書情報_処理名称, date));
                return result;
            case "161":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysShinsaKetteiSeikyuMeisai.国保連取込_介護給付費等審査決定請求明細表情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysShinsaKetteiSeikyuMeisai.国保連取込_介護給付費等審査決定請求明細表情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysShinsaKetteiSeikyuMeisai.国保連取込_介護給付費等審査決定請求明細表情報_処理名称, date));
                return result;
            case "162":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo.国保連取込_総合事業費審査決定請求明細表情報_バッチID,
                        date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo.国保連取込_総合事業費審査決定請求明細表情報_一覧表示順,
                        date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo.国保連取込_総合事業費審査決定請求明細表情報_処理名称,
                        date));
                return result;
            case "171":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKagoKetteiTuchi.国保連取込_介護給付費過誤決定通知書情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKagoKetteiTuchi.国保連取込_介護給付費過誤決定通知書情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKagoKetteiTuchi.国保連取込_介護給付費過誤決定通知書情報_処理名称, date));
                return result;
            default:
                return set隠し項目For介護給付費再審査決定通知書情報(result, 交換情報識別番号, date);
        }
    }

    private KokuhorenTorikomiJohoInfo set隠し項目For介護給付費再審査決定通知書情報(KokuhorenTorikomiJohoInfo result,
            RString 交換情報識別番号, RDate date) {
        switch (交換情報識別番号.toString()) {
            case "172":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSaishinsaKetteiTuchi.国保連取込_介護給付費再審査決定通知書情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSaishinsaKetteiTuchi.国保連取込_介護給付費再審査決定通知書情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSaishinsaKetteiTuchi.国保連取込_介護給付費再審査決定通知書情報_処理名称, date));
                return result;
            case "175":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoKagoKetteiTuchi.国保連取込_総合事業費過誤決定通知書情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoKagoKetteiTuchi.国保連取込_総合事業費過誤決定通知書情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSogoJigyoKagoKetteiTuchi.国保連取込_総合事業費過誤決定通知書情報_処理名称, date));
                return result;
            case "221":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSikyuKetteishaIchiran.国保連取込_償還払支給決定者一覧情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSikyuKetteishaIchiran.国保連取込_償還払支給決定者一覧情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSikyuKetteishaIchiran.国保連取込_償還払支給決定者一覧情報_処理名称, date));
                return result;
            case "222":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysFuSikyuKetteishaIchiran.国保連取込_償還払不支給決定者一覧情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysFuSikyuKetteishaIchiran.国保連取込_償還払不支給決定者一覧情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysFuSikyuKetteishaIchiran.国保連取込_償還払不支給決定者一覧情報_処理名称, date));
                return result;
            case "331":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKogakuKyufuTaishoshaIchiran.国保連取込_高額介護サービス費給付対象者一覧表情報_バッチID,
                        date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKogakuKyufuTaishoshaIchiran.国保連取込_高額介護サービス費給付対象者一覧表情報_一覧表示順,
                        date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKogakuKyufuTaishoshaIchiran.国保連取込_高額介護サービス費給付対象者一覧表情報_処理名称,
                        date));
                return result;
            case "351":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKogakuSikyuKetteishaIchiran.国保連取込_高額介護サービス費支給不支給決定者一覧表情報_バッチID,
                        date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKogakuSikyuKetteishaIchiran.国保連取込_高額介護サービス費支給不支給決定者一覧表情報_一覧表示順,
                        date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKogakuSikyuKetteishaIchiran.国保連取込_高額介護サービス費支給不支給決定者一覧表情報_処理名称,
                        date));
                return result;
            case "386":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo.国保連取込_高額合算支給額計算結果連絡票情報_バッチID,
                        date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo.国保連取込_高額合算支給額計算結果連絡票情報_一覧表示順,
                        date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo.国保連取込_高額合算支給額計算結果連絡票情報_処理名称,
                        date));
                return result;
            case "533":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysJukyushaKoshinKekka.国保連取込_受給者情報更新結果情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysJukyushaKoshinKekka.国保連取込_受給者情報更新結果情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysJukyushaKoshinKekka.国保連取込_受給者情報更新結果情報_処理名称, date));
                return result;
            default:
                return set隠し項目For受給者台帳情報一覧(result, 交換情報識別番号, date);
        }
    }

    private KokuhorenTorikomiJohoInfo set隠し項目For受給者台帳情報一覧(KokuhorenTorikomiJohoInfo result,
            RString 交換情報識別番号, RDate date) {
        switch (交換情報識別番号.toString()) {
            case "534":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysJukyushaDaichoJohoIchiran.国保連取込_受給者台帳情報一覧_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysJukyushaDaichoJohoIchiran.国保連取込_受給者台帳情報一覧_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysJukyushaDaichoJohoIchiran.国保連取込_受給者台帳情報一覧_処理名称, date));
                return result;
            case "537":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysJukyushaDaichoTotsugoKekka.国保連取込_受給者台帳突合結果情報随時_処理名称, date));
                return result;
            case "631":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSeikyugakuTuchi_Kohi.国保連取込_介護給付費等請求額通知書公費情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSeikyugakuTuchi_Kohi.国保連取込_介護給付費等請求額通知書公費情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSeikyugakuTuchi_Kohi.国保連取込_介護給付費等請求額通知書公費情報_処理名称, date));
                return result;
            case "641":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKohiJukyushabetsuIchiran.国保連取込_介護給付費公費受給者別一覧表情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKohiJukyushabetsuIchiran.国保連取込_介護給付費公費受給者別一覧表情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKohiJukyushabetsuIchiran.国保連取込_介護給付費公費受給者別一覧表情報_処理名称, date));
                return result;
            case "651":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKagoKetteiTuchi_Kohi.国保連取込_介護給付費過誤決定通知書公費情報_処理名称, date));
                return result;
            case "652":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysSaishinsaKetteiTuchi_Kohi.国保連取込_介護給付費再審査決定通知書公費情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysSaishinsaKetteiTuchi_Kohi.国保連取込_介護給付費再審査決定通知書公費情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysSaishinsaKetteiTuchi_Kohi.国保連取込_介護給付費再審査決定通知書公費情報_処理名称, date));
                return result;
            case "741":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysHenreiIchiranhyo.国保連取込_請求明細給付管理票返戻保留一覧表情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysHenreiIchiranhyo.国保連取込_請求明細給付管理票返戻保留一覧表情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysHenreiIchiranhyo.国保連取込_請求明細給付管理票返戻保留一覧表情報_処理名称, date));
                return result;
            case "37H":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKogakugassanJikofutangakuShomeisho.国保連取込_高額合算自己負担額証明書情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKogakugassanJikofutangakuShomeisho.国保連取込_高額合算自己負担額証明書情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKogakugassanJikofutangakuShomeisho.国保連取込_高額合算自己負担額証明書情報_処理名称, date));
                return result;
            case "37J":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKogakugassanJikofutangakuKakunin.国保連取込_高額合算自己負担額確認情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKogakugassanJikofutangakuKakunin.国保連取込_高額合算自己負担額確認情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKogakugassanJikofutangakuKakunin.国保連取込_高額合算自己負担額確認情報_処理名称, date));
                return result;
            case "38B":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKogakugassanSikyuKetteiTuchi.国保連取込_高額合算支給不支給決定通知書情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKogakugassanSikyuKetteiTuchi.国保連取込_高額合算支給不支給決定通知書情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKogakugassanSikyuKetteiTuchi.国保連取込_高額合算支給不支給決定通知書情報_処理名称, date));
                return result;
            case "38P":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKogakugassanKyufuJisseki.国保連取込_高額合算給付実績情報_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKogakugassanKyufuJisseki.国保連取込_高額合算給付実績情報_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKogakugassanKyufuJisseki.国保連取込_高額合算給付実績情報_処理名称, date));
                return result;
            case "5C3":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKyodoshoriJukyushaKoshinKekka.国保連取込_共同処理用受給者情報更新結果_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKyodoshoriJukyushaKoshinKekka.国保連取込_共同処理用受給者情報更新結果_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKyodoshoriJukyushaKoshinKekka.国保連取込_共同処理用受給者情報更新結果_処理名称, date));
                return result;
            case "5C4":
                result.setバッチID(DbBusinessConifg.get(
                        ConfigKeysKyodoshoriJukyushaJohoIchiran.国保連取込_共同処理用受給者情報一覧_バッチID, date));
                result.set一覧表示順(DbBusinessConifg.get(
                        ConfigKeysKyodoshoriJukyushaJohoIchiran.国保連取込_共同処理用受給者情報一覧_一覧表示順, date));
                result.set処理名(DbBusinessConifg.get(
                        ConfigKeysKyodoshoriJukyushaJohoIchiran.国保連取込_共同処理用受給者情報一覧_処理名称, date));
                return result;
            default:
                return result;
        }
    }

    /**
     * getParamter
     *
     * @param 交換情報識別番号 RString
     * @return RString
     */
    public RString getParamter(RString 交換情報識別番号) {
        switch (交換情報識別番号.toString()) {
            case "111":
                return new RString("39");
            case "112":
                return new RString("19");
            case "114":
                return new RString("27");
            case "121":
                return new RString("16");
            case "122":
                return new RString("17");
            case "151":
                return new RString("12");
            case "152":
                return new RString("13");
            case "161":
                return new RString("20");
            case "162":
                return new RString("38");
            case "171":
                return new RString("21");
            case "172":
                return new RString("22");
            case "175":
                return new RString("37");
            case "221":
                return new RString("28");
            case "222":
                return new RString("29");
            case "331":
                return new RString("30");
            case "351":
                return new RString("31");
            case "386":
                return new RString("34");
            case "533":
                return new RString("26");
            default:
                return getParamterForOthers(交換情報識別番号);
        }
    }

    private RString getParamterForOthers(RString 交換情報識別番号) {
        switch (交換情報識別番号.toString()) {
            case "534": // TODO 受給者台帳情報一覧("534"), 現時点画面がない
                return RString.EMPTY;
            case "537": // TODO 受給者台帳突合結果情報随時("537"), 現時点画面がない
                return new RString("");
            case "631":
                return new RString("14");
            case "641":
                return new RString("25");
            case "651":
                return new RString("23");
            case "652":
                return new RString("24");
            case "741":
                return new RString("15");
            case "37H":
                return new RString("33");
            case "37J":
                return new RString("32");
            case "38B":
                return new RString("35");
            case "38P":
                return new RString("36");
            case "5C3":
                return new RString("18");
            case "5C4": // TODO 共同処理用受給者情報一覧("5C4"), 現時点画面がない
                return RString.EMPTY;
            default:
                return RString.EMPTY;
        }
    }
}
