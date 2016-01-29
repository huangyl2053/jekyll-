/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.koikinaijushochitokureishaichiranhyo;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 広域内住所地特例者一覧表ボディのITEMです。
 */
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KoikinaiJushochitokureishaIchiranhyoBodyItem {

    private final RString 被保険者番号;
    private final RString 氏名カナ;
    private final RString 生年月日;
    private final RString 住所コード;
    private final RString 行政区CD;
    private final RString 行政区;
    private final RString 取得日;
    private final RString 取得届出日;
    private final RString 喪失日;
    private final RString 喪失届出日;
    private final RString 資格区分;
    private final RString 住特;
    private final RString 識別コード;
    private final RString 氏名;
    private final RString 性別;
    private final RString 世帯コード;
    private final RString 住所;
    private final RString 広住取得日;
    private final RString 広住取得届出日;
    private final RString 広住喪失日;
    private final RString 広住喪失届出日;
    private final RString 措置市町村コード;
    private final RString 措置市町村名称;

    /**
     * インスタンスを生成します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 氏名カナ 氏名カナ
     * @param 生年月日 生年月日
     * @param 住所コード 住所コード
     * @param 行政区CD 行政区CD
     * @param 行政区 行政区
     * @param 取得日 取得日
     * @param 取得届出日 取得届出日
     * @param 喪失日 喪失日
     * @param 喪失届出日 喪失届出日
     * @param 資格区分 資格区分
     * @param 住特 住特
     * @param 識別コード 識別コード
     * @param 氏名 氏名
     * @param 性別 性別
     * @param 世帯コード 世帯コード
     * @param 住所 住所
     * @param 広住取得日 広住取得日
     * @param 広住取得届出日 広住取得届出日
     * @param 広住喪失日 広住喪失日
     * @param 広住喪失届出日 広住喪失届出日
     * @param 措置市町村コード 措置市町村コード
     * @param 措置市町村名称 措置市町村名称
     */
    public KoikinaiJushochitokureishaIchiranhyoBodyItem(
            RString 被保険者番号,
            RString 氏名カナ,
            RString 生年月日,
            RString 住所コード,
            RString 行政区CD,
            RString 行政区,
            RString 取得日,
            RString 取得届出日,
            RString 喪失日,
            RString 喪失届出日,
            RString 資格区分,
            RString 住特,
            RString 識別コード,
            RString 氏名,
            RString 性別,
            RString 世帯コード,
            RString 住所,
            RString 広住取得日,
            RString 広住取得届出日,
            RString 広住喪失日,
            RString 広住喪失届出日,
            RString 措置市町村コード,
            RString 措置市町村名称) {

        this.被保険者番号 = 被保険者番号;
        this.氏名カナ = 氏名カナ;
        this.生年月日 = 生年月日;
        this.住所コード = 住所コード;
        this.行政区CD = 行政区CD;
        this.行政区 = 行政区;
        this.取得日 = 取得日;
        this.取得届出日 = 取得届出日;
        this.喪失日 = 喪失日;
        this.喪失届出日 = 喪失届出日;
        this.資格区分 = 資格区分;
        this.住特 = 住特;
        this.識別コード = 識別コード;
        this.氏名 = 氏名;
        this.性別 = 性別;
        this.世帯コード = 世帯コード;
        this.住所 = 住所;
        this.広住取得日 = 広住取得日;
        this.広住取得届出日 = 広住取得届出日;
        this.広住喪失日 = 広住喪失日;
        this.広住喪失届出日 = 広住喪失届出日;
        this.措置市町村コード = 措置市町村コード;
        this.措置市町村名称 = 措置市町村名称;
    }
}
