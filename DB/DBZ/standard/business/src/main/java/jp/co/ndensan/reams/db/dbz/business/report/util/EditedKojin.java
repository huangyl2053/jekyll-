/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.report.util;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.kojin.IKojin;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.IName;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaBanchi;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Katagaki;
import jp.co.ndensan.reams.uz.uza.biz.SetaiCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 *
 * 編集後個人のクラスです。
 */
public class EditedKojin {

    private final IKojin 個人;
    private final ChohyoSeigyoKyotsu 帳票制御共通;

    /**
     * コンストラクタです。
     *
     * @param 個人 IKojin
     * @param 帳票制御共通 ChohyoSeigyoKyotsu
     */
    public EditedKojin(IKojin 個人, ChohyoSeigyoKyotsu 帳票制御共通) {
        this.個人 = requireNonNull(個人, UrSystemErrorMessages.値がnull.getReplacedMessage("個人"));
        this.帳票制御共通 = requireNonNull(帳票制御共通, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票制御共通"));
    }

    /**
     * 名称を返します。
     *
     * @return 名称
     */
    public IName get名称() {
        return 個人.get名称();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        if (個人.is日本人()) {
            return 個人.get生年月日().toFlexibleDate().wareki().eraType(EraType.KANJI)
                    .firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE)
                    .fillType(FillType.BLANK).toDateString();
        } else {
            return 個人.get生年月日().toFlexibleDate().seireki().toDateString();
        }
    }

    /**
     * 生年月日ForCsvを返します。
     *
     * @return 生年月日ForCsv
     */
    public RString get生年月日ForCsv() {
        return 個人.get生年月日().toFlexibleDate()
                .seireki().separator(Separator.JAPANESE)
                .fillType(FillType.ZERO).toDateString();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return 個人.get性別().getName().getShortJapanese();
    }

    /**
     * 識別コードを返します。
     *
     * @return 識別コード
     */
    public ShikibetsuCode get識別コード() {
        return 個人.get識別コード();
    }

    /**
     * 世帯コードを返します。
     *
     * @return 世帯コード
     */
    public SetaiCode get世帯コード() {
        return 個人.get世帯コード();
    }

    /**
     * 世帯主名を返します。
     *
     * @return 世帯主名
     */
    public AtenaMeisho get世帯主名() {
        return 個人.get世帯主名();
    }

    /**
     * 続柄を返します。
     *
     * @return 続柄
     */
    public RString get続柄() {
        return 個人.get続柄();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return 個人.get住所().get郵便番号().getEditedYubinNo();
    }

    /**
     * 編集後住所を返します。
     *
     * @return 編集後住所
     */
    public RString get編集後住所() {
        // TODO QA-752 dbz.business→dbb.service
        return RString.EMPTY;
    }

    /**
     * 方書を返します。
     *
     * @return 方書
     */
    public Katagaki get方書() {
        return 個人.get住所().get方書();
    }

    /**
     * 町域を返します。
     *
     * @return 町域
     */
    public RString get町域() {
        return 個人.get住所().get住所();
    }

    /**
     * 番地を返します。
     *
     * @return 番地
     */
    public AtenaBanchi get番地() {
        return 個人.get住所().get番地().getBanchi();
    }
}
