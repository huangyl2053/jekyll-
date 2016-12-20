package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.saikinshorisha.SaikinShorisha;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ValidationMessageControlPairs;

/*
 * このコードはツールによって生成されました。
 */
public interface ISaikinShorishaDiv extends ICommonChildDivBaseProperties {

    void initialize();

    ValidationMessageControlPairs validate();

    RString getSelectedHihokenshaNo();

    void update(RString hihokenshaNo, RString hihokenshaName);
}
