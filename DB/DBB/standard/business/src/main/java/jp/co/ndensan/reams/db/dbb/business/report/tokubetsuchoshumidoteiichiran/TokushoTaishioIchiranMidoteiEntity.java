/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.tokubetsuchoshumidoteiichiran;

import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 特徴対象一覧未同定のエンティティです。
 *
 * @reamsid_L DBB-1860-070 liuyang
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TokushoTaishioIchiranMidoteiEntity {

    /**
     * 基礎年金番号
     */
    private RString kisoNenkinNo;
    /**
     * 年金コード
     */
    private RString nenkinCode;
    /**
     * /**
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
     * 生年月日
     */
    private RDate umareYMD;
    /**
     * 性別コード
     */
    private RString seibetsuCode;
    /**
     * カナ氏名
     */
    private RString kanaShimei;
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
     * is厚労省
     */
    private Boolean koroshoHantei;
    /**
     * 不一致理由コード
     */
    private RString fuichiRiyuCode;
    private boolean flag;
    /**
     * 市町村コード
     */
    private RString shichosonCode;
    /**
     * 被保険者番号
     */
    private RString hihokenshaNo;

    /**
     * 特徴対象一覧未同定エンティティクラスのコンストラクタです。
     */
    public TokushoTaishioIchiranMidoteiEntity() {
    }

    /**
     * 特徴対象一覧未同定エンティティクラスのコンストラクタです。
     *
     * @param kisoNenkinNo 基礎年金番号
     * @param nenkinCode 年金コード
     * @param umareYMD 生年月日
     * @param seibetsuCode 性別コード
     * @param kanaShimei カナ氏名
     * @param kanjiShimei 漢字氏名
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param koroshoHantei 厚労省判定
     */
    public TokushoTaishioIchiranMidoteiEntity(RString kisoNenkinNo,
            RString nenkinCode,
            RDate umareYMD,
            RString seibetsuCode,
            RString kanaShimei,
            RString kanjiShimei,
            RString yubinNo,
            RString jusho,
            Boolean koroshoHantei
    ) {
        this.kisoNenkinNo = kisoNenkinNo;
        this.nenkinCode = nenkinCode;
        this.umareYMD = umareYMD;
        this.seibetsuCode = seibetsuCode;
        this.kanaShimei = kanaShimei;
        this.kanjiShimei = kanjiShimei;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.koroshoHantei = koroshoHantei;
        flag = true;
    }

    /**
     * 特徴対象一覧未同定エンティティクラスのコンストラクタです。
     *
     * @param kisoNenkinNo 基礎年金番号
     * @param nenkinCode 年金コード
     * @param umareYMD 生年月日
     * @param seibetsuCode 性別コード
     * @param kanaShimei カナ氏名
     * @param kanjiShimei 漢字氏名
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param koroshoHantei 厚労省判定
     * @param fuichiRiyuCode 不一致理由コード
     * @param shichosonCode 市町村コード
     * @param hihokenshaNo 被保険者番号
     */
    public TokushoTaishioIchiranMidoteiEntity(RString kisoNenkinNo,
            RString nenkinCode,
            RDate umareYMD,
            RString seibetsuCode,
            RString kanaShimei,
            RString kanjiShimei,
            RString yubinNo,
            RString jusho,
            Boolean koroshoHantei,
            RString fuichiRiyuCode,
            RString shichosonCode,
            RString hihokenshaNo
    ) {
        this.kisoNenkinNo = kisoNenkinNo;
        this.nenkinCode = nenkinCode;
        this.umareYMD = umareYMD;
        this.seibetsuCode = seibetsuCode;
        this.kanaShimei = kanaShimei;
        this.kanjiShimei = kanjiShimei;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.koroshoHantei = koroshoHantei;
        this.fuichiRiyuCode = fuichiRiyuCode;
        this.shichosonCode = shichosonCode;
        this.hihokenshaNo = hihokenshaNo;
        flag = true;
    }

    /**
     * 特徴対象一覧未同定エンティティクラスのコンストラクタです。
     *
     * @param karichoshuKisoNenkinNo 仮徴収・基礎年金番号
     * @param honchoshuKisoNenkinNo 本徴収・基礎年金番号
     * @param yokunendoKarichoshuKisoNenkinNo 翌年度仮徴収・基礎年金番号
     * @param karichoshuNenkinCode 仮徴収・年金コード
     * @param honchoshuKisonenkinCode 本徴収・基礎年金コード
     * @param yokunendoKariChoshuKisonenkinCode 翌年度仮徴収・基礎年金コード
     * @param umareYMD 生年月日
     * @param seibetsuCode 性別コード
     * @param kanaShimei カナ氏名
     * @param kanjiShimei 漢字氏名
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param koroshoHantei 厚労省判定
     * @param fuichiRiyuCode 不一致理由コード
     */
    public TokushoTaishioIchiranMidoteiEntity(RString karichoshuKisoNenkinNo,
            RString honchoshuKisoNenkinNo,
            RString yokunendoKarichoshuKisoNenkinNo,
            RString karichoshuNenkinCode,
            RString honchoshuKisonenkinCode,
            RString yokunendoKariChoshuKisonenkinCode,
            RDate umareYMD,
            RString seibetsuCode,
            RString kanaShimei,
            RString kanjiShimei,
            RString yubinNo,
            RString jusho,
            Boolean koroshoHantei,
            RString fuichiRiyuCode
    ) {
        this.karichoshuKisoNenkinNo = karichoshuKisoNenkinNo;
        this.honchoshuKisoNenkinNo = honchoshuKisoNenkinNo;
        this.yokunendoKarichoshuKisoNenkinNo = yokunendoKarichoshuKisoNenkinNo;
        this.karichoshuNenkinCode = karichoshuNenkinCode;
        this.honchoshuKisonenkinCode = honchoshuKisonenkinCode;
        this.yokunendoKariChoshuKisonenkinCode = yokunendoKariChoshuKisonenkinCode;
        this.umareYMD = umareYMD;
        this.seibetsuCode = seibetsuCode;
        this.kanaShimei = kanaShimei;
        this.kanjiShimei = kanjiShimei;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.koroshoHantei = koroshoHantei;
        this.fuichiRiyuCode = fuichiRiyuCode;
        flag = false;
    }

    /**
     * 特徴対象一覧未同定エンティティクラスのコンストラクタです。
     *
     * @param karichoshuKisoNenkinNo 仮徴収・基礎年金番号
     * @param honchoshuKisoNenkinNo 本徴収・基礎年金番号
     * @param yokunendoKarichoshuKisoNenkinNo 翌年度仮徴収・基礎年金番号
     * @param karichoshuNenkinCode 仮徴収・年金コード
     * @param honchoshuKisonenkinCode 本徴収・基礎年金コード
     * @param yokunendoKariChoshuKisonenkinCode 翌年度仮徴収・基礎年金コード
     * @param umareYMD 生年月日
     * @param seibetsuCode 性別コード
     * @param kanaShimei カナ氏名
     * @param kanjiShimei 漢字氏名
     * @param yubinNo 郵便番号
     * @param jusho 住所
     * @param koroshoHantei 厚労省判定
     * @param fuichiRiyuCode 不一致理由コード
     * @param shichosonCode 市町村コード
     * @param hihokenshaNo 被保険者番号
     */
    public TokushoTaishioIchiranMidoteiEntity(RString karichoshuKisoNenkinNo,
            RString honchoshuKisoNenkinNo,
            RString yokunendoKarichoshuKisoNenkinNo,
            RString karichoshuNenkinCode,
            RString honchoshuKisonenkinCode,
            RString yokunendoKariChoshuKisonenkinCode,
            RDate umareYMD,
            RString seibetsuCode,
            RString kanaShimei,
            RString kanjiShimei,
            RString yubinNo,
            RString jusho,
            Boolean koroshoHantei,
            RString fuichiRiyuCode,
            RString shichosonCode,
            RString hihokenshaNo) {
        this.karichoshuKisoNenkinNo = karichoshuKisoNenkinNo;
        this.honchoshuKisoNenkinNo = honchoshuKisoNenkinNo;
        this.yokunendoKarichoshuKisoNenkinNo = yokunendoKarichoshuKisoNenkinNo;
        this.karichoshuNenkinCode = karichoshuNenkinCode;
        this.honchoshuKisonenkinCode = honchoshuKisonenkinCode;
        this.yokunendoKariChoshuKisonenkinCode = yokunendoKariChoshuKisonenkinCode;
        this.umareYMD = umareYMD;
        this.seibetsuCode = seibetsuCode;
        this.kanaShimei = kanaShimei;
        this.kanjiShimei = kanjiShimei;
        this.yubinNo = yubinNo;
        this.jusho = jusho;
        this.koroshoHantei = koroshoHantei;
        this.fuichiRiyuCode = fuichiRiyuCode;
        this.shichosonCode = shichosonCode;
        this.hihokenshaNo = hihokenshaNo;
        flag = false;
    }
}
