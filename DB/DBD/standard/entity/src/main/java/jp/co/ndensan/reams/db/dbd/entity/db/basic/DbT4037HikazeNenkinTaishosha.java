package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 非課税年金対象者テーブルの項目定義クラスです。
 * <br/>  連合会から送付される非課税年金対象者情報と被保険者との関連を管理する
 */
public enum DbT4037HikazeNenkinTaishosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 年度
     * <br/>取込、登録各画面で指定した処理年度。処理扱いをした調定年度に相当する
     */
    nendo(2147483647, 0),
    /**
     * 処理区分
     * <br/>11：年次処理、12：月次処理
     */
    shorikubun(2, 0),
    /**
     * 対象月
     * <br/>5月、7月～12月を"005", "007"～"012"、翌1月～6月を"101"～"106"のように管理する
     */
    taishom(3, 0),
    /**
     * 基礎年金番号
     * <br/>DT基礎年金番号と必ず一致する（登録画面の入力項目管理）
     */
    kisonenkinno(10, 0),
    /**
     * 現基礎年金番号
     * <br/>判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     */
    genkisonenkinno(10, 0),
    /**
     * 年金コード
     * <br/>DT年金コードと必ず一致する（登録画面の入力項目管理）、判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     */
    nenkincode(4, 0),
    /**
     * 被保険者番号
     * <br/>関連付けられた被保険者番号。被保険者と関連づいていない非課税年金対象者情報は、被保険者番号空白
     */
    hihokenshano(10, 0),
    /**
     * 登録区分
     * <br/>1：取込、2：画面登録
     */
    torokukubun(1, 0),
    /**
     * DTレコード区分
     * <br/>（以下、"DT"項目は国保連合会から送付の「非課税年金対象者情報」の内容を格納）2：データレコード
     */
    dtrecordkubun(1, 0),
    /**
     * DT市町村コード
     * <br/>総務省で定められた地方公共団体コード
     */
    dtcitycode(5, 0),
    /**
     * DT年金保険者コード
     * <br/>年金保険者コード※コードマスタは使用しない。判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     */
    dtnenkinhokenshacode(3, 0),
    /**
     * DT通知内容コード
     * <br/>93：補足給付初回回付（年次）情報、94：補足給付初回回付（月次）情報
     */
    dttsuchinaiyocode(2, 0),
    /**
     * DT予備１
     * <br/>オールスペース（半角）
     */
    dtyobi1(1, 0),
    /**
     * DT制度コード
     * <br/>5：介護（補足給付）
     */
    dtseidocode(1, 0),
    /**
     * DT作成年月日
     * <br/>レコード作成時の年月日。同一年金のが存在する場合、DT作成年月日がより新しいものを勘案する
     */
    dtsakuseiymd(8, 0),
    /**
     * DT基礎年金番号
     * <br/>非課税年金対象者の基礎年金番号
     */
    dtkisonenkinno(10, 0),
    /**
     * DT年金コード
     * <br/>非課税年金対象者の"年金種別"2桁-"年金区分コード１"1桁-"年金区分コード２"1桁
     * <br/>※コードマスタは使用しない。
     */
    dtnenkincode(4, 0),
    /**
     * DT予備２
     * <br/>オールスペース（半角）
     */
    dtyobi2(3, 0),
    /**
     * DT生年月日
     * <br/>非課税年金対象者の生年月日
     */
    dtbirthday(8, 0),
    /**
     * DT性別
     * <br/>非課税年金対象者の性別コード　1：男、2：女
     */
    dtseibetsu(1, 0),
    /**
     * DTカナ氏名
     * <br/>非課税年金対象者のカナ氏名
     * <br/>（カナ文字については、カナ大文字のみが設定される）
     */
    dtkanashimei(25, 0),
    /**
     * DTシフトコード１
     * <br/>漢字シフトコード：16進"1B2442"
     */
    dtshiftcode1(3, 0),
    /**
     * DT漢字氏名
     * <br/>非課税年金の漢字氏名
     */
    dtkanjishimei(50, 0),
    /**
     * DTシフトコード２
     * <br/>カナシフトコード：16進"1B284A"
     */
    dtshiftcode2(3, 0),
    /**
     * DT郵便番号
     * <br/>非課税年金対象者の郵便番号
     */
    dtyubinno(7, 0),
    /**
     * DTカナ住所
     * <br/>非課税年金対象者のカナ住所
     * <br/>島しょ以外の市町村については、都道府県名は省略される。
     * <br/>（カナ文字については、カナ大文字のみが設定される）
     */
    dtkanajusho(80, 0),
    /**
     * DTシフトコード３
     * <br/>漢字シフトコード：16進"1B2442"
     */
    dtshiftcode3(3, 0),
    /**
     * DT漢字住所
     * <br/>非課税年金対象者の漢字住所
     * <br/>島しょ以外の市町村については、都道府県名は省略される。
     */
    dtkanjijusho(160, 0),
    /**
     * DTシフトコード４
     * <br/>カナシフトコード：16進"1B284A"
     */
    dtshiftcode4(3, 0),
    /**
     * DT対象年
     * <br/>計単対象年（西暦）。年金の受給年を表し、負担限度額認定には、認定年度前年分を勘案する。判定時に同一年金とみなすキーの１つ（対象年+DT年金保険者コード+現基礎年金番号+年金コード先頭3桁）
     */
    dttaishoy(4, 0),
    /**
     * DT訂正表示
     * <br/>0：初回回付（年次／新裁分）、1：月次回付（遡及改定分）
     */
    dtteiseihyoji(1, 0),
    /**
     * DT各種区分
     * <br/>01：新規者、02：前年度継続者
     */
    dtkakushukubun(2, 0),
    /**
     * DT処理結果
     * <br/>00：初期値、01：受給権の失権（死亡失権は含まない）、02：差止・一時停止・停止
     */
    dtshorikekka(2, 0),
    /**
     * DT予備３
     * <br/>オールスペース（半角）
     */
    dtyobi3(1, 0),
    /**
     * DT予備４
     * <br/>オールスペース（半角）
     */
    dtyobi4(8, 0),
    /**
     * DT金額１
     * <br/>非課税年金対象者の非課税年金額（右詰、11桁左ゼロ埋め）
     */
    dtkingaku1(11, 0),
    /**
     * DT金額予備１
     * <br/>オールスペース（半角）
     */
    dtkingakuyobi1(11, 0),
    /**
     * DT金額予備２
     * <br/>オールスペース（半角）
     */
    dtkingakuyobi2(11, 0),
    /**
     * DT予備５
     * <br/>オールスペース（半角）
     */
    dtyobi5(53, 0),
    /**
     * DT共済年金証書記号番号
     * <br/>共済年金記号番号。共済組合以外はオールスペース（半角）。農林原簿移管者は共通農林整理番号
     */
    dtkyosainenkinshoshokigono(15, 0);

    private final int maxLength;
    private final int scale;

    private DbT4037HikazeNenkinTaishosha(int maxLength, int scale) {
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
