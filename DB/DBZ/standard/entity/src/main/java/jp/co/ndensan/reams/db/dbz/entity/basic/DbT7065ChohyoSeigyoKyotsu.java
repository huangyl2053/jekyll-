package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 帳票制御共通テーブルの項目定義クラスです。
 * <br/> 帳票制御のために必要な共通的な項目を管理します。
 */
public enum DbT7065ChohyoSeigyoKyotsu implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * サブ業務コード
     */
    subGyomuCode(2147483647, 0),
    /**
     * 帳票分類ID
     */
    chohyoBunruiID(2147483647, 0),
    /**
     * 帳票分類名称
     */
    chohyoBunruiMeisho(40, 0),
    /**
     * 住所編集区分
     * <br/>0:市町村共通　1:帳票独自
     */
    jushoHenshuKubun(1, 0),
    /**
     * 住所編集都道府県名表示有無
     */
    jushoHenshuTodoufukenMeiHyojiUmu(1, 0),
    /**
     * 住所編集郡名表示有無
     */
    jushoHenshuGunMeiHyojiUmu(1, 0),
    /**
     * 住所編集市町村名表示有無
     */
    jushoHenshuShichosonMeiHyojiUmu(1, 0),
    /**
     * 住所編集町域編集方法
     * <br/>1:住所＋番地　
     * <br/>2:行政区＋番地　
     * <br/>3:住所＋番地（行政区）　
     * <br/>4:番地のみ　
     * <br/>5:表示なし(住所は印字しない)
     */
    jushoHenshuChoikiHenshuHoho(1, 0),
    /**
     * 住所編集方書表示有無
     */
    jushoHenshuKatagakiHyojiUmu(1, 0),
    /**
     * 世帯主表示有無
     */
    SetainushiHyojiUmu(1, 0),
    /**
     * カスタマバーコード使用有無
     */
    customerBarCodeShiyoUmu(1, 0),
    /**
     * カスタマバーコード変換エラー編集方法
     * <br/>1:空白をセット  2:入力郵便番号をセット
     */
    customerBarCodeHenkanErrHenshuHoho(1, 0),
    /**
     * 外部帳票文字切れ制御
     * <br/>0:印字しない　1:印字可能範囲まで印字する
     */
    gaibuChohyoMojigireSeigyo(1, 0),
    /**
     * 内部帳票文字切れ制御
     * <br/>1:印字可能範囲まで印字する　2:オーバーフローマークを印字する
     */
    naibuChohyoMojigireSeigyo(1, 0),
    /**
     * 文字切れ分離制御
     * <br/>0:山分けしない　1:山分けする
     */
    mojigireBunriSeigyo(1, 0),
    /**
     * 定型文文字サイズ
     * <br/>1:フォント小　
     * <br/>2:フォント大　
     * <br/>3:フォント上小下大　
     * <br/>4:フォント上大下小
     */
    teikeibunMojiSize(1, 0),
    /**
     * 口座マスク有無
     */
    kozaMaskUmu(1, 0),
    /**
     * 口座名義人カナ優先区分
     * <br/>0:表示しない　1:表示する
     */
    kozaMeigininKanaYusenKubun(1, 0),
    /**
     * 代行プリント有無
     */
    daikoPrintUmu(1, 0),
    /**
     * 地区表示1
     * <br/>0:なし　
     * <br/>1:住所コード　
     * <br/>2:行政区コード
     */
    chikuHyoji1(1, 0),
    /**
     * 地区表示2
     * <br/>0:なし　
     * <br/>3:地区コード１　
     * <br/>4:地区コード２　
     * <br/>5:地区コード３　
     * <br/>6:納組コード
     */
    chikuHyoji2(1, 0),
    /**
     * 地区表示3
     * <br/>0:なし　
     * <br/>3:地区コード１　
     * <br/>4:地区コード２　
     * <br/>5:地区コード３　
     * <br/>6:納組コード
     */
    chikuHyoji3(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7065ChohyoSeigyoKyotsu(int maxLength, int scale) {
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
