/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.chosahyoservicejokyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 厚生労働省IFコード　02Aに対応した列挙体
 *
 * @author N2818
 */
public enum ServiceJokyo02A {

    /**
     * 厚生労働省IFコードが 02A のときの 訪問介護 の各設定値
     */
    訪問介護(1, "x207", 1, "訪問介護（ホームヘルプサービス）            ：", "回 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 訪問入浴介護 の各設定値
     */
    訪問入浴介護(2, "x207", 2, "訪問入浴介護                                ：", "回 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 訪問看護 の各設定値
     */
    訪問看護(3, "x207", 3, "訪問看護                                    ：", " 回 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 訪問リハビリ の各設定値
     */
    訪問リハビリ(4, "x207", 4, "訪問リハビリテーション                      ：", "回 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 居宅療養管理指導 の各設定値
     */
    居宅療養管理指導(5, "x207", 5, "居宅療養管理指導                            ：", "回 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 通所介護 の各設定値
     */
    通所介護(6, "x207", 6, "通所介護（デイサービス）                    ：", "回 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 通所リハビリ の各設定値
     */
    通所リハビリ(7, "x207", 7, "通所リハビリテーション                      ：", "回 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 福祉用具貸与 の各設定値
     */
    福祉用具貸与(8, "x207", 8, "福祉用具貸与                                ：", "品目"),
    /**
     * 厚生労働省IFコードが 02A のときの 短期入所生活介護 の各設定値
     */
    短期入所生活介護(9, "x207", 9, "短期入所生活介護（ショートステイ）          ：", "日 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 短期入所療養介護 の各設定値
     */
    短期入所療養介護(10, "x207", 10, "短期入所療養介護                            ：", "日 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 認知症対応型共同生活介護 の各設定値
     */
    認知症対応型共同生活介護(11, "x207", 11, "認知症対応型共同生活介護（グループホーム）　：", "日 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 特定施設入所者生活介護 の各設定値
     */
    特定施設入所者生活介護(12, "x207", 12, "特定施設入居者生活介護                      ：", "日 /月"),
    /**
     * 厚生労働省IFコードが 02A のときの 福祉用具購入 の各設定値
     */
    福祉用具購入(13, "x207", 13, "特定福祉用具販売                            ：", "品目 /6月間");

    private final int 連番;
    private final RString ニモニック;
    private final int テーブル内連番;
    private final RString 帳票上のラベル名称;
    private final RString 単位;

    private ServiceJokyo02A(int remban, String nimonic, int tableRemban, String name, String tani) {
        this.連番 = remban;
        this.ニモニック = new RString(nimonic);
        this.テーブル内連番 = tableRemban;
        this.帳票上のラベル名称 = new RString(name);
        this.単位 = new RString(tani);
    }

    /**
     * このEnum内での連番を返します
     *
     * @return Enum内での連番
     */
    public int get連番() {
        return this.連番;
    }

    /**
     * 各要素がセットされているテーブルのニモニックを返します。<br />
     * 継承元、先の2種類が存在するため、1桁目はxとしています。
     *
     * @return 要素がセットされているテーブルニモニック
     */
    public RString getニモニック() {
        return this.ニモニック;
    }

    /**
     * 各要素がセットされているテーブル内での連番を返します。<br />
     * この連番は必ずしも 連番 とは一致しません。
     *
     * @return 要素がセットされているテーブル内での連番
     */
    public int getテーブル内連番() {
        return this.テーブル内連番;
    }

    /**
     * 選択された要素の帳票上でのラベル名を返します。
     *
     * @return 帳票上のラベル名
     */
    public RString get帳票上のラベル名称() {
        return this.帳票上のラベル名称;
    }

    /**
     * 選択された要素の帳票上での単位を返します。
     *
     * @return 帳票上の単位
     */
    public RString get単位() {
        return this.単位;
    }
}
