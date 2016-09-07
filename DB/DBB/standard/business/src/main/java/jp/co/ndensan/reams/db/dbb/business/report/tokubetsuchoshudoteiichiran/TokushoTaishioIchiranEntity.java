/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshudoteiichiran;

import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴対象一覧のエンティティです。
 *
 * @reamsid_L DBB-1860-060 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokushoTaishioIchiranEntity {

    /**
     * 被保険者番号
     */
    private RString hihokenshaNo;
    /**
     * 基礎年金番号
     */
    private RString kisoNenkinNo;
    /**
     * 年金コード
     */
    private RString nenkinCode;
    /**
     * 仮徴収・基礎年金番号
     */
    private RString karichoshuKisoNenkinNo;
    /**
     * 本徴収・基礎年金番号
     */
    private RString honchoshuKisoNenkinNo;
    /**
     * 翌年度仮徴収・基礎年金番号
     */
    private RString yokunendoKarichoshuKisoNenkinNo;
    /**
     * 仮徴収・年金コード
     */
    private RString karichoshuNenkinCode;
    /**
     * 本徴収・基礎年金コード
     */
    private RString honchoshuKisonenkinCode;
    /**
     * 翌年度仮徴収・基礎年金コード
     */
    private RString yokunendoKariChoshuKisonenkinCode;
    /**
     * 識別コード
     */
    private ShikibetsuCode shikibetuCode;
    /**
     * 世帯コード
     */
    private RString setaiCode;
    /**
     * 行政区コード
     */
    private RString gyoseikuCode;
    /**
     * 生年月日
     */
    private RDate umareYMD;
    /**
     * 住民種別コード
     */
    private RString juminShubetsuCode;
    /**
     * 性別コード
     */
    private RString seibetsuCode;
    /**
     * カナ氏名上段
     */
    private RString kanashimeiJodan;
    /**
     * カナ氏名下段
     */
    private RString kanashimeiKadan;
    /**
     * 漢字氏名
     */
    private RString kanjiShimei;
    /**
     * 郵便番号
     */
    private RString yubinNo;
    /**
     * 住所
     */
    private RString jusho;

    /**
     * 特徴対象一覧エンティティクラスのコンストラクタです。
     */
    public TokushoTaishioIchiranEntity() {
    }

    /**
     * 特徴対象一覧エンティティクラスのコンストラクタです。
     *
     * @param hihokenshaNo 被保険者番号
     * @param kisoNenkinNo 基礎年金番号
     * @param nenkinCode 年金コード
     * @param shikibetuCode 識別コード
     * @param setaiCode 世帯コード
     * @param gyoseikuCode 行政区コード
     * @param umareYMD 生年月日
     * @param juminShubetsuCode 住民種別コード
     * @param seibetsuCode 性別コード
     * @param kanashimeiJodan カナ氏名上段
     * @param kanashimeiKadan カナ氏名下段
     * @param kanjiShimei 漢字氏名
     * @param yubinNo 郵便番号
     * @param jusho 住所
     *
     */
    public TokushoTaishioIchiranEntity(RString hihokenshaNo,
            RString kisoNenkinNo,
            RString nenkinCode,
            ShikibetsuCode shikibetuCode,
            RString setaiCode,
            RString gyoseikuCode,
            RDate umareYMD,
            RString juminShubetsuCode,
            RString seibetsuCode,
            RString kanashimeiJodan,
            RString kanashimeiKadan,
            RString kanjiShimei,
            RString yubinNo,
            RString jusho) {
        this.hihokenshaNo = hihokenshaNo;
        this.kisoNenkinNo = kisoNenkinNo;
        this.nenkinCode = nenkinCode;
        this.shikibetuCode = shikibetuCode;
        this.setaiCode = setaiCode;
        this.gyoseikuCode = gyoseikuCode;
        this.umareYMD = umareYMD;
        this.juminShubetsuCode = juminShubetsuCode;
        this.seibetsuCode = seibetsuCode;
        this.kanashimeiJodan = kanashimeiJodan;
        this.kanashimeiKadan = kanashimeiKadan;
        this.kanjiShimei = kanjiShimei;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
    }

    /**
     * 特徴対象一覧エンティティクラスのコンストラクタです。
     *
     * @param hihokenshaNo 被保険者番号
     * @param karichoshuKisoNenkinNo 仮徴収・基礎年金番号
     * @param honchoshuKisoNenkinNo 本徴収・基礎年金番号
     * @param yokunendoKarichoshuKisoNenkinNo 翌年度仮徴収・基礎年金番号
     * @param karichoshuNenkinCode 仮徴収・年金コード
     * @param honchoshuKisonenkinCode 本徴収・基礎年金コード
     * @param yokunendoKariChoshuKisonenkinCode 翌年度仮徴収・基礎年金コード
     * @param shikibetuCode 識別コード
     * @param setaiCode 世帯コード
     * @param gyoseikuCode 行政区コード
     * @param umareYMD 生年月日
     * @param juminShubetsuCode 住民種別コード
     * @param seibetsuCode 性別コード
     * @param kanashimeiJodan カナ氏名上段
     * @param kanashimeiKadan カナ氏名下段
     * @param kanjiShimei 漢字氏名
     * @param yubinNo 郵便番号
     * @param jusho 住所
     */
    public TokushoTaishioIchiranEntity(RString hihokenshaNo,
            RString karichoshuKisoNenkinNo,
            RString honchoshuKisoNenkinNo,
            RString yokunendoKarichoshuKisoNenkinNo,
            RString karichoshuNenkinCode,
            RString honchoshuKisonenkinCode,
            RString yokunendoKariChoshuKisonenkinCode,
            ShikibetsuCode shikibetuCode,
            RString setaiCode,
            RString gyoseikuCode,
            RDate umareYMD,
            RString juminShubetsuCode,
            RString seibetsuCode,
            RString kanashimeiJodan,
            RString kanashimeiKadan,
            RString kanjiShimei,
            RString yubinNo,
            RString jusho) {
        this.hihokenshaNo = hihokenshaNo;
        this.karichoshuKisoNenkinNo = karichoshuKisoNenkinNo;
        this.honchoshuKisoNenkinNo = honchoshuKisoNenkinNo;
        this.yokunendoKarichoshuKisoNenkinNo = yokunendoKarichoshuKisoNenkinNo;
        this.karichoshuNenkinCode = karichoshuNenkinCode;
        this.honchoshuKisonenkinCode = honchoshuKisonenkinCode;
        this.yokunendoKariChoshuKisonenkinCode = yokunendoKariChoshuKisonenkinCode;
        this.shikibetuCode = shikibetuCode;
        this.setaiCode = setaiCode;
        this.gyoseikuCode = gyoseikuCode;
        this.umareYMD = umareYMD;
        this.juminShubetsuCode = juminShubetsuCode;
        this.seibetsuCode = seibetsuCode;
        this.kanashimeiJodan = kanashimeiJodan;
        this.kanashimeiKadan = kanashimeiKadan;
        this.kanjiShimei = kanjiShimei;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
    }
}
