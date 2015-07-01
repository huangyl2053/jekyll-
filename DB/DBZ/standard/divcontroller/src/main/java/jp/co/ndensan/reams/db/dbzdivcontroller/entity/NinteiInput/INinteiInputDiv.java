package jp.co.ndensan.reams.db.dbzdivcontroller.entity.NinteiInput;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/*
 * このコードはツールによって生成されました。
 */
public interface INinteiInputDiv extends ICommonChildDivBaseProperties {

    RString get審査会意見();

    FlexibleDate get認定年月日();

    RString get要介護度コード();

    FlexibleDate get有効開始年月日();

    FlexibleDate get有効終了年月日();

    RString get認定区分();

    List<dgServiceIchiran_Row> getサービス一覧();

    List<KeyValueDataSource> getみなし更新申請();

    void set審査会意見(RString 審査会意見);

    void set認定年月日(FlexibleDate 認定年月日);

    void set要介護度コード(RString 要介護度);

    void set有効開始年月日(FlexibleDate 有効開始年月日);

    void set有効終了年月日(FlexibleDate 有効終了年月日);

    void set認定区分(RString 認定区分);

    void setサービス一覧(List<dgServiceIchiran_Row> サービス一覧);

    void setみなし更新申請(List<KeyValueDataSource> みなし更新申請);

    void clear();

    void intialize();

    void setHdnHihokenshaNo(RString hdnHihokenshaNo);

    void setHdnKoroshoIfShikibetsuCode(RString hdnKoroshoIfShikibetsuCode);

    void setMode_ShoriType(NinteiInputDiv.ShoriType value);

    void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo);

}
