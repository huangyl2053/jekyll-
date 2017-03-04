/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE5230001;

import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5230001.dgTaishoshaIchiran_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.divcontroller.util.KaigoRowState;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 */
@lombok.AllArgsConstructor
public class TaishoshaIchiranRow {

    private final dgTaishoshaIchiran_Row aRow;

    /**
     * @return 状態
     */
    public KaigoRowState getJotai() {
        RString value = aRow.getJotai();
        if (RString.isNullOrEmpty(value)) {
            return KaigoRowState.空白;
        }
        return KaigoRowState.valueOf(value.toString());
    }

    /**
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo getShinseishoKanriNo() {
        return new ShinseishoKanriNo(aRow.getShinseishoKanriNo());
    }

    /**
     * @return 申請区分(法)
     */
    public Code getHoreiKubunCode() {
        return new Code(aRow.getShinseiKubunLawCode());
    }

    /**
     * @return 取下区分
     */
    public Code getTorisageKubunCode() {
        return new Code(aRow.getTorisageKubunCode());
    }

    /**
     * @return 二次判定日
     */
    public FlexibleDate getNijiHanteiYMD() {
        return aRow.getNijiHanteiDate().getValue();
    }

    /**
     * @return 今回二次判定結果コード
     */
    public Code getKonkaiNijiHanteiCode() {
        RString code = aRow.getKonkaiNijiHanteiCode();
        if (RString.isNullOrEmpty(code)) {
            return Code.EMPTY;
        } else {
            return new Code(code);
        }
    }

    /**
     * @return 状態像例
     */
    public Code getJotaiZoReiCode() {
        RString code = aRow.getJotaizoCode();
        if (RString.isNullOrEmpty(code)) {
            return Code.EMPTY;
        } else {
            return new Code(code);
        }
    }

    /**
     * @return 判定結果コード
     */
    @CheckForNull
    public HanteiKekkaCode getHanteiKekka() {
        RString code = aRow.getHanteiKekkaCode();
        if (RString.isNullOrEmpty(code)) {
            return null;
        }
        return HanteiKekkaCode.toValue(code);
    }

    /**
     * @return 認定有効期間開始日
     */
    @Nonnull
    public FlexibleDate getNinteiYukoKikanKaishiYMD() {
        FlexibleDate f = aRow.getNinteiKikanKaishi().getValue();
        return f == null ? FlexibleDate.EMPTY : f;
    }

    /**
     * @return 認定有効期間終了日
     */
    @Nonnull
    public FlexibleDate getNinteiYukoKikanShuryoYMD() {
        FlexibleDate f = aRow.getNinteiKikanShuryo().getValue();
        return f == null ? FlexibleDate.EMPTY : f;
    }

    /**
     * @return 月数、空の場合は0.
     */
    public int getNinteiKikanTsukiSu() {
        Decimal num = aRow.getNinteiKikanTukisu().getValue();
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /**
     * @return 審査会メモ
     */
    public RString getShinsakaiMemo() {
        return aRow.getHidMemo();
    }

    /**
     * @return 審査会意見種類
     */
    public RString getShinsakaiIkenShuruiCode() {
        return aRow.getHidIkenCode();
    }

    /**
     * @return 審査会意見
     */
    public RString getShinsakaiIken() {
        return aRow.getHidIken();
    }

    /**
     * @return 二次判定結果変更理由
     */
    public RString getIchijiHanteiKekkaHenkoRiyu() {
        return aRow.getIchijiHanteiKekkaHenkoRiyu();
    }

    /**
     * @return 取下げ区分に変更がある場合、{@code true}
     */
    public boolean hasTorisageKubunChanged() {
        return Objects.equals(aRow.getTorisageKubunCode(), aRow.getHenkoMaeTorisageKubunCode());
    }

    /**
     * @return 値が変更される前の取下げ区分。
     */
    public Code getHenkoMaeTorisageKubun() {
        return new Code(aRow.getHenkoMaeTorisageKubunCode());
    }

    /**
     *
     * @return
     */
    public RString toMd5() {
        RStringBuilder builder = new RStringBuilder();
        builder.append(getNijiHanteiYMD().seireki().toDateString());
        builder.append(getKonkaiNijiHanteiCode());
        builder.append(getJotaiZoReiCode());
        HanteiKekkaCode c = getHanteiKekka();
        builder.append(c == null ? RString.EMPTY : c.getコード());
        builder.append(getNinteiYukoKikanKaishiYMD().seireki().toDateString());
        builder.append(getNinteiYukoKikanShuryoYMD().seireki().toDateString());
        builder.append(getNinteiKikanTsukiSu());
        builder.append(getShinsakaiMemo());
        builder.append(getShinsakaiIkenShuruiCode());
        builder.append(getShinsakaiIken());
        builder.append(getIchijiHanteiKekkaHenkoRiyu());
        return new RString(DigestUtils.md5Hex(builder.toString()));
    }
}
