package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 受領委任契約事業者テーブルの項目定義クラスです。
 */
public enum DbT3077JuryoininKeiyakuJigyosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 事業者契約番号
     * <br/>1からの連番付番
     */
    jigyoshaKeiyakuNo(10, 0),
    /**
     * 開始年月日
     */
    kaishiYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 終了年月日
     */
    shuryoYMD(2147483647, 0),
    /**
     * 届出年月日
     */
    todokedeYMD(2147483647, 0),
    /**
     * 届出者住所
     */
    todokedeAddress(100, 0),
    /**
     * 届出者事業者名称
     */
    todokedeJigyoshaName(20, 0),
    /**
     * 届出者代表者氏名
     */
    todokedeDaihyoshaName(30, 0),
    /**
     * 金融機関コード
     */
    kinyuKikanCode(2147483647, 0),
    /**
     * 支店コード
     */
    shitenCode(2147483647, 0),
    /**
     * 口座種別
     */
    kozaShubetsu(1, 0),
    /**
     * 口座番号
     */
    kozaNo(2147483647, 0),
    /**
     * 通帳記号
     */
    tsuchoKigo(2147483647, 0),
    /**
     * 通帳番号
     */
    tsuchoNo(2147483647, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(2147483647, 0),
    /**
     * 口座名義人漢字
     */
    kozaMeigininKanji(2147483647, 0),
    /**
     * 事業者FAX番号
     */
    jigyoshaFaxNo(2147483647, 0),
    /**
     * 契約登録年月日
     */
    keiyakuTorokuYMD(2147483647, 0),
    /**
     * 送付先部署
     */
    sofusakiBusho(80, 0),
    /**
     * 営業形態
     * <br/>個人、法人の分け
     */
    eigyoKeitai(1, 0),
    /**
     * 住宅改修契約有無
     * <br/>0:契約無し,1:契約有り（償還払給付契約有無が「0」である場合に限る）
     */
    jutakuKaishuKeiyakuUmu(1, 0),
    /**
     * 特定福祉用具販売契約有無
     * <br/>0:契約無し,1:契約有り（償還払給付契約有無が「0」である場合に限る）
     */
    tokuteiFukushiYoguHanbaiKeiyakuUmu(1, 0),
    /**
     * 償還払給付契約有無
     * <br/>0:契約無し,1:契約有り（住宅改修契約有無および特定福祉用具販売契約有無が「0」である場合に限る）
     */
    shokanbaraiKyufuKeiyakuUmu(1, 0),
    /**
     * 高額給付契約有無
     * <br/>0:契約無し,1:契約有り
     */
    kogakuKyufuKeiyakuUmu(1, 0),
    /**
     * 契約事業者番号
     */
    keiyakuJigyoshaNo(2147483647, 0),
    /**
     * 取扱確約書有無
     */
    toriatsukaiKakuyakushoUmu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3077JuryoininKeiyakuJigyosha(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
