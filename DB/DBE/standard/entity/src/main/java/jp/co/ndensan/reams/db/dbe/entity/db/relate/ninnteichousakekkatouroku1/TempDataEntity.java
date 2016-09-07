/*
 *Tochangethislicenseheader,chooseLicenseHeadersinProjectProperties.
 *Tochangethistemplatefile,chooseTools|templates
 *andopenthetemplateintheeditor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.ninnteichousakekkatouroku1;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 認定調査結果登録1のtempDataクラスです。
 *
 * @reamsid_L DBE-0040-010 xuyue
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class TempDataEntity {

    private RString temp_厚労省IF識別コード;
    private RString temp_認定調査依頼区分コード;
    private RString temp_現在の状況コード;
    private RString temp_現在のサービス区分コード;
    private RString temp_利用施設名;
    private RString temp_利用施設住所;
    private RString temp_利用施設電話番号;
    private RString temp_利用施設郵便番号;
    private RString temp_特記;
    private RString temp_認定調査回数;
    private RString temp_認定調査委託区分コード;
    private RString temp_調査実施場所コード;
    private RString temp_調査実施場所名称;
    private RString temp_調査委託先コード;
    private RString temp_調査員コード;
    private RString temp_調査実施年月日;

}
