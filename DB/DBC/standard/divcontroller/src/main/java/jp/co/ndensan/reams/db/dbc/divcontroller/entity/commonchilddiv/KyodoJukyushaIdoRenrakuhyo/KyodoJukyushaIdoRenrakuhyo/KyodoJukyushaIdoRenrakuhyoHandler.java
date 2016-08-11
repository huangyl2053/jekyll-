/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;

import jp.co.ndensan.reams.db.dbc.business.core.kyodoshorijukyushateiseirenrakuhyo.param.KyodoshoriyoJukyushaIdoRenrakuhyoParam;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ビジネス設計_DBCMN81004_共同処理受給者異動情報変更箇所判定
 *
 * @reamsid_L DBC-1951-030 chenaoqi
 */
public class KyodoJukyushaIdoRenrakuhyoHandler {

    private static final RString SPLIT = new RString("～");
    private static final RString RString_0 = new RString("0");
    private static final RString RString_1 = new RString("1");

    /**
     * 基本送付情報判定のメソッドです
     *
     * @param 初期化異動情報Entity KyodoshoriyoJukyushaIdoRenrakuhyoParam
     * @param 画面項目異動情報Entity KyodoshoriyoJukyushaIdoRenrakuhyoParam
     * @param checkFlag boolean
     * @return boolean
     */
    public boolean is基本送付情報変更あり(KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化異動情報Entity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 画面項目異動情報Entity, boolean checkFlag) {
        boolean flag = false;
        if (checkFlag) {
            RString 初期化Key = RString.EMPTY;
            RString 画面項目Key = RString.EMPTY;
            if (初期化異動情報Entity.get基本情報Entity() != null) {
                RString 初期化被保険者氏名 = 初期化異動情報Entity.get基本情報Entity().get被保険者氏名();
                RString 初期化電話番号 = 初期化異動情報Entity.get基本情報Entity().get電話番号() != null
                        ? 初期化異動情報Entity.get基本情報Entity().get電話番号().value() : RString.EMPTY;
                RString 初期化郵便番号 = 初期化異動情報Entity.get基本情報Entity().get郵便番号() != null
                        ? 初期化異動情報Entity.get基本情報Entity().get郵便番号().value() : RString.EMPTY;
                RString 初期化住所 = 初期化異動情報Entity.get基本情報Entity().get住所();
                RString 初期化住所カナ = 初期化異動情報Entity.get基本情報Entity().get住所カナ();
                RString 初期化帳票出力順序コード = 初期化異動情報Entity.get基本情報Entity().get帳票出力順序コード();
                初期化Key = 初期化被保険者氏名.concat(SPLIT).concat(初期化電話番号)
                        .concat(SPLIT).concat(初期化郵便番号).concat(SPLIT).concat(初期化住所)
                        .concat(SPLIT).concat(初期化住所カナ).concat(SPLIT).concat(初期化帳票出力順序コード);
            }
            if (画面項目異動情報Entity.get基本情報Entity() != null) {
                RString 画面項目被保険者氏名 = 画面項目異動情報Entity.get基本情報Entity().get被保険者氏名();
                RString 画面項目電話番号 = 画面項目異動情報Entity.get基本情報Entity().get電話番号() != null
                        ? 画面項目異動情報Entity.get基本情報Entity().get電話番号().value() : RString.EMPTY;
                RString 画面項目郵便番号 = 画面項目異動情報Entity.get基本情報Entity().get郵便番号() != null
                        ? 画面項目異動情報Entity.get基本情報Entity().get郵便番号().value() : RString.EMPTY;
                RString 画面項目住所 = 画面項目異動情報Entity.get基本情報Entity().get住所();
                RString 画面項目住所カナ = 画面項目異動情報Entity.get基本情報Entity().get住所カナ();
                RString 画面項目帳票出力順序コード = 画面項目異動情報Entity.get基本情報Entity().get帳票出力順序コード();
                画面項目Key = 画面項目被保険者氏名.concat(SPLIT).concat(画面項目電話番号)
                        .concat(SPLIT).concat(画面項目郵便番号).concat(SPLIT).concat(画面項目住所)
                        .concat(SPLIT).concat(画面項目住所カナ).concat(SPLIT).concat(画面項目帳票出力順序コード);
            }
            if (!初期化Key.equals(画面項目Key)) {
                flag = true;
            }
        } else {
            return flag;
        }
        return flag;
    }

    /**
     * 償還送付情報判定のメソッドです
     *
     * @param 初期化異動情報Entity KyodoshoriyoJukyushaIdoRenrakuhyoParam
     * @param 画面項目異動情報Entity KyodoshoriyoJukyushaIdoRenrakuhyoParam
     * @param checkFlag boolean
     * @return boolean
     */
    public boolean is償還送付情報変更あり(KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化異動情報Entity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 画面項目異動情報Entity, boolean checkFlag) {
        boolean flag = false;
        if (checkFlag) {
            RString 初期化Key = RString.EMPTY;
            RString 画面項目Key = RString.EMPTY;
            if (初期化異動情報Entity.get償還情報Entity() != null) {
                RString 初期化開始年月日 = 初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止開始年月日() != null
                        ? new RString(初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止開始年月日().toString()) : RString.EMPTY;
                RString 初期化終了年月日 = 初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止終了年月日() != null
                        ? new RString(初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止終了年月日().toString()) : RString.EMPTY;
                RString 初期化一時差止区分 = 初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止区分コード();
                RString 初期化一時差止金額 = 初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止金額() != null
                        ? new RString(初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止金額().toString()) : RString.EMPTY;
                初期化Key = 初期化開始年月日.concat(SPLIT).concat(初期化終了年月日)
                        .concat(SPLIT).concat(初期化一時差止区分).concat(SPLIT).concat(初期化一時差止金額);
            }
            if (画面項目異動情報Entity.get償還情報Entity() != null) {
                RString 画面項目開始年月日 = 画面項目異動情報Entity.get償還情報Entity().get保険給付支払一時差止開始年月日() != null
                        ? new RString(初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止開始年月日().toString()) : RString.EMPTY;
                RString 画面項目終了年月日 = 画面項目異動情報Entity.get償還情報Entity().get保険給付支払一時差止終了年月日() != null
                        ? new RString(初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止終了年月日().toString()) : RString.EMPTY;
                RString 画面項目一時差止区分 = 画面項目異動情報Entity.get償還情報Entity().get保険給付支払一時差止区分コード();
                RString 画面項目一時差止金額 = 画面項目異動情報Entity.get償還情報Entity().get保険給付支払一時差止金額() != null
                        ? new RString(初期化異動情報Entity.get償還情報Entity().get保険給付支払一時差止金額().toString()) : RString.EMPTY;
                初期化Key = 画面項目開始年月日.concat(SPLIT).concat(画面項目終了年月日)
                        .concat(SPLIT).concat(画面項目一時差止区分).concat(SPLIT).concat(画面項目一時差止金額);
            }
            if (!初期化Key.equals(画面項目Key)) {
                flag = true;
            }
        } else {
            return flag;
        }
        return flag;
    }

    /**
     * 高額送付情報判定のメソッドです
     *
     * @param 初期化異動情報Entity KyodoshoriyoJukyushaIdoRenrakuhyoParam
     * @param 画面項目異動情報Entity KyodoshoriyoJukyushaIdoRenrakuhyoParam
     * @param checkFlag boolean
     * @return boolean
     */
    public boolean is高額送付情報変更あり(KyodoshoriyoJukyushaIdoRenrakuhyoParam 初期化異動情報Entity,
            KyodoshoriyoJukyushaIdoRenrakuhyoParam 画面項目異動情報Entity, boolean checkFlag) {
        boolean flag = false;
        if (checkFlag) {
            RString 初期化Key = RString.EMPTY;
            RString 画面項目Key = RString.EMPTY;
            if (初期化異動情報Entity.get高額情報Entity() != null) {
                RString 初期化世帯集約番号 = 初期化異動情報Entity.get高額情報Entity().get世帯集約番号() != null
                        ? 初期化異動情報Entity.get高額情報Entity().get世帯集約番号().value() : RString.EMPTY;
                RString 初期化世帯所得区分 = 初期化異動情報Entity.get高額情報Entity().get世帯所得区分コード();
                RString 初期化所得区分 = 初期化異動情報Entity.get高額情報Entity().get所得区分コード();
                boolean 初期化老齢福祉年金 = 初期化異動情報Entity.get高額情報Entity().is老齢福祉年金受給有フラグ();
                boolean 初期化利用者負担第２段階 = 初期化異動情報Entity.get高額情報Entity().is利用者負担第２段階有フラグ();
                boolean 初期化支給申請書出力 = 初期化異動情報Entity.get高額情報Entity().is支給申請書出力有フラグ();
                RString 初期化老齢福祉年金code;
                RString 初期化利用者負担第２段階code;
                RString 初期化支給申請書出力code;
                if (初期化老齢福祉年金) {
                    初期化老齢福祉年金code = RString_1;
                } else {
                    初期化老齢福祉年金code = RString_0;
                }
                if (初期化利用者負担第２段階) {
                    初期化利用者負担第２段階code = RString_1;
                } else {
                    初期化利用者負担第２段階code = RString_0;
                }
                if (初期化支給申請書出力) {
                    初期化支給申請書出力code = RString_1;
                } else {
                    初期化支給申請書出力code = RString_0;
                }
                初期化Key = 初期化世帯集約番号.concat(SPLIT).concat(初期化世帯所得区分).concat(SPLIT).concat(初期化所得区分)
                        .concat(SPLIT).concat(初期化老齢福祉年金code).concat(SPLIT)
                        .concat(初期化利用者負担第２段階code).concat(SPLIT).concat(初期化支給申請書出力code);
            }
            if (画面項目異動情報Entity.get高額情報Entity() != null) {
                RString 画面項目世帯集約番号 = 画面項目異動情報Entity.get高額情報Entity().get世帯集約番号() != null
                        ? 初期化異動情報Entity.get高額情報Entity().get世帯集約番号().value() : RString.EMPTY;
                RString 画面項目世帯所得区分 = 画面項目異動情報Entity.get高額情報Entity().get世帯所得区分コード();
                RString 画面項目所得区分 = 画面項目異動情報Entity.get高額情報Entity().get所得区分コード();
                boolean 画面項目老齢福祉年金 = 画面項目異動情報Entity.get高額情報Entity().is老齢福祉年金受給有フラグ();
                boolean 画面項目利用者負担第２段階 = 画面項目異動情報Entity.get高額情報Entity().is利用者負担第２段階有フラグ();
                boolean 画面項目支給申請書出力 = 画面項目異動情報Entity.get高額情報Entity().is支給申請書出力有フラグ();
                RString 画面項目老齢福祉年金code;
                RString 画面項目利用者負担第２段階code;
                RString 画面項目支給申請書出力code;
                if (画面項目老齢福祉年金) {
                    画面項目老齢福祉年金code = RString_1;
                } else {
                    画面項目老齢福祉年金code = RString_0;
                }
                if (画面項目利用者負担第２段階) {
                    画面項目利用者負担第２段階code = RString_1;
                } else {
                    画面項目利用者負担第２段階code = RString_0;
                }
                if (画面項目支給申請書出力) {
                    画面項目支給申請書出力code = RString_1;
                } else {
                    画面項目支給申請書出力code = RString_0;
                }
                画面項目Key = 画面項目世帯集約番号.concat(SPLIT).concat(画面項目世帯所得区分).concat(SPLIT).concat(画面項目所得区分)
                        .concat(SPLIT).concat(画面項目老齢福祉年金code).concat(SPLIT)
                        .concat(画面項目利用者負担第２段階code).concat(SPLIT).concat(画面項目支給申請書出力code);
            }
            if (!初期化Key.equals(画面項目Key)) {
                flag = true;
            }
        } else {
            return flag;
        }
        return flag;
    }

}
