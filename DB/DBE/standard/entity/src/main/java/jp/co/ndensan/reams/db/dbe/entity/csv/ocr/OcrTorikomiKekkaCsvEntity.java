/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.csv.ocr;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbz.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvField;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;

/**
 *
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
@lombok.Setter
public class OcrTorikomiKekkaCsvEntity {

    private static final int HOKENSHANO_LENGTH = 6;
    private static final int HIHOKENSHANO_LENGTH = 10;

    @CsvField(order = 10, name = "ID")
    private RString oCRID;
    @CsvField(order = 20, name = "帳票連番")
    private RString sheetID;
    @CsvField(order = 30, name = "証記載保険者番号")
    private RString 証記載保険者番号;
    @CsvField(order = 40, name = "申請日")
    private RString 申請日西暦;
    @CsvField(order = 50, name = "被保険者番号")
    private RString 被保険者番号;
    @CsvField(order = 60, name = "氏名")
    private RString 氏名;
    @CsvField(order = 70, name = "氏名カナ")
    private RString 氏名カナ;
    @CsvField(order = 80, name = "区分")
    private RString 結果;
    private int kekkaCode;
    @CsvField(order = 90, name = "備考")
    private RString 備考;

    /**
     * @return PersonalDataへ変換可能な場合、変換結果を保持したインスタンス.　不可能な場合、空.
     */
    public Optional<PersonalData> toPersonalDataIfPossible() {
        if (RString.isNullOrEmpty(this.証記載保険者番号)
                && RString.isNullOrEmpty(this.被保険者番号)) {
            return Optional.empty();
        }
        if (this.証記載保険者番号.length() != HOKENSHANO_LENGTH
                && this.被保険者番号.length() != HIHOKENSHANO_LENGTH) {
            return Optional.empty();
    }
        return Optional.of(PersonalData.of(new ShikibetsuCode(this.証記載保険者番号.substring(0, 5).concat(this.被保険者番号)),
                ExpandedInformations.被保険者番号.fromValue(this.被保険者番号)));
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.oCRID);
        hash = 13 * hash + Objects.hashCode(this.sheetID);
        hash = 13 * hash + Objects.hashCode(this.証記載保険者番号);
        hash = 13 * hash + Objects.hashCode(this.申請日西暦);
        hash = 13 * hash + Objects.hashCode(this.被保険者番号);
        hash = 13 * hash + Objects.hashCode(this.氏名);
        hash = 13 * hash + Objects.hashCode(this.氏名カナ);
        hash = 13 * hash + Objects.hashCode(this.結果);
        hash = 13 * hash + Objects.hashCode(this.備考);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OcrTorikomiKekkaCsvEntity other = (OcrTorikomiKekkaCsvEntity) obj;
        if (!Objects.equals(this.oCRID, other.oCRID)) {
            return false;
        }
        if (!Objects.equals(this.sheetID, other.sheetID)) {
            return false;
        }
        if (!Objects.equals(this.証記載保険者番号, other.証記載保険者番号)) {
            return false;
        }
        if (!Objects.equals(this.申請日西暦, other.申請日西暦)) {
            return false;
        }
        if (!Objects.equals(this.被保険者番号, other.被保険者番号)) {
            return false;
        }
        if (!Objects.equals(this.氏名, other.氏名)) {
            return false;
        }
        if (!Objects.equals(this.氏名カナ, other.氏名カナ)) {
            return false;
        }
        if (!Objects.equals(this.結果, other.結果)) {
            return false;
        }
        if (!Objects.equals(this.備考, other.備考)) {
            return false;
        }
        return true;
    }

    /**
     * 指定のインスタンスが持つ値を、このインスタンスへコピーします。
     *
     * @param other コピー元
     */
    public void shallowCopy(OcrTorikomiKekkaCsvEntity other) {
        this.oCRID = other.oCRID;
        this.sheetID = other.sheetID;
        this.証記載保険者番号 = other.証記載保険者番号;
        this.申請日西暦 = other.申請日西暦;
        this.被保険者番号 = other.被保険者番号;
        this.氏名 = other.氏名;
        this.氏名カナ = other.氏名カナ;
        this.結果 = other.結果;
        this.kekkaCode = other.kekkaCode;
        this.備考 = other.備考;
    }
}
