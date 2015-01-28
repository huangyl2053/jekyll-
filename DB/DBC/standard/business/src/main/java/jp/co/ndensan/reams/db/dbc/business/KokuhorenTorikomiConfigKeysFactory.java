/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business;

import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysFuSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysHenreiIchiranhyo;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysJukyushaDaichoJohoIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysJukyushaDaichoTotsugoKekka;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysJukyushaKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKagoKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKagoKetteiTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakuKyufuTaishoshaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakuSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakugassanJikofutangakuKakunin;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakugassanJikofutangakuShomeisho;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakugassanKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakugassanSikyuKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKohiJukyushabetsuIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKyodoshoriJukyushaJohoIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKyodoshoriJukyushaKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKyufuJisseki;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKyufuJissekiKoshinKekka;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKyufuKanrihyo;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSaishinsaKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSaishinsaKetteiTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSeikyugakuTuchi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSeikyugakuTuchi_Kohi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysShikakuShogohyo;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysShinsaKetteiSeikyuMeisai;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSikyuKetteishaIchiran;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSogoJigyoKagoKetteiTuchi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSogoJigyoSeikyugakuTuchi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSogoJigyoShikakuShogohyo;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.IConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public class KokuhorenTorikomiConfigKeysFactory {

    public static IConfigKeysKokuhorenTorikomi getEnumValues(RString 交換情報識別番号) {

        switch (交換情報識別番号.toString()) {

            case "111": //受給者情報更新結果情報
                return ConfigKeysJukyushaKoshinKekka.getEnum();
            case "112": //共同処理用受給者情報更新結果
                return ConfigKeysKyodoshoriJukyushaKoshinKekka.getEnum();
            case "114": //給付実績情報
                return ConfigKeysKyufuJisseki.getEnum();
            case "121": //給付管理票情報
                return ConfigKeysKyufuKanrihyo.getEnum();
            case "122": //給付実績更新結果情報
                return ConfigKeysKyufuJissekiKoshinKekka.getEnum();
            case "151": //介護給付費等審査決定請求明細表情報
                return ConfigKeysShinsaKetteiSeikyuMeisai.getEnum();
            case "152": //介護給付費過誤決定通知書情報
                return ConfigKeysKagoKetteiTuchi.getEnum();
            case "161": //介護給付費再審査決定通知書情報
                return ConfigKeysSaishinsaKetteiTuchi.getEnum();
            case "162": //介護給付費等請求額通知書情報
                return ConfigKeysSeikyugakuTuchi.getEnum();
            case "171": //介護給付費過誤決定通知書公費情報
                return ConfigKeysKagoKetteiTuchi_Kohi.getEnum();
            case "172": //介護給付費再審査決定通知書公費情報
                return ConfigKeysSaishinsaKetteiTuchi_Kohi.getEnum();
            case "175": //介護給付費等請求額通知書公費情報
                return ConfigKeysSeikyugakuTuchi_Kohi.getEnum();
            case "221": //介護給付費公費受給者別一覧表情報
                return ConfigKeysKohiJukyushabetsuIchiran.getEnum();
            case "222": //償還払支給決定者一覧情報
                return ConfigKeysSikyuKetteishaIchiran.getEnum();
            case "331": //償還払不支給決定者一覧情報
                return ConfigKeysFuSikyuKetteishaIchiran.getEnum();
            case "351": //高額介護サービス費給付対象者一覧表情報
                return ConfigKeysKogakuKyufuTaishoshaIchiran.getEnum();
            case "386": //高額介護サービス費支給不支給決定者一覧表情報
                return ConfigKeysKogakuSikyuKetteishaIchiran.getEnum();
            case "533": //受給者台帳情報一覧
                return ConfigKeysJukyushaDaichoJohoIchiran.getEnum();
            case "534": //受給者台帳突合結果情報随時
                return ConfigKeysJukyushaDaichoTotsugoKekka.getEnum();
            case "537": //共同処理用受給者情報一覧
                return ConfigKeysKyodoshoriJukyushaJohoIchiran.getEnum();
            case "631": //高額合算自己負担額確認情報
                return ConfigKeysKogakugassanJikofutangakuKakunin.getEnum();
            case "641": //高額合算自己負担額証明書情報
                return ConfigKeysKogakugassanJikofutangakuShomeisho.getEnum();
            case "651": //高額合算支給額計算結果連絡票情報
                return ConfigKeysKogakugassanSikyugakuKeisanKekkaRenrakuhyo.getEnum();
            case "652": //高額合算支給不支給決定通知書情報
                return ConfigKeysKogakugassanSikyuKetteiTuchi.getEnum();
            case "741": //高額合算給付実績情報
                return ConfigKeysKogakugassanKyufuJisseki.getEnum();
            case "37H": //総合事業費過誤決定通知書情報
                return ConfigKeysSogoJigyoKagoKetteiTuchi.getEnum();
            case "37J": //総合事業費請求額通知書情報
                return ConfigKeysSogoJigyoSeikyugakuTuchi.getEnum();
            case "38B": //総合事業費審査決定請求明細表情報
                return ConfigKeysSogoJigyoShinsaKetteiSeikyumeisaihyo.getEnum();
            case "38P": //請求明細給付管理票返戻保留一覧表情報
                return ConfigKeysHenreiIchiranhyo.getEnum();
            case "5C3": //資格照合表情報
                return ConfigKeysShikakuShogohyo.getEnum();
            case "5C4": //総合事業費資格照合表情報
                return ConfigKeysSogoJigyoShikakuShogohyo.getEnum();
            default:
        }

        return null;
    }
}
