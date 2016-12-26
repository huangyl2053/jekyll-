package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho;

import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;

/**
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBA-0180-010 lishengli
 */
public interface IHokenshaJohoDiv extends ICommonChildDivBaseProperties {

    public void intialize(HokenjaNo 保険者番号);

    public abstract void clear();

    public abstract RString getHokenjaNo();

    public abstract RString getHokenjaName();

    public abstract void setHokenjaNo(RString 保険者番号);

    public abstract void setHokenjaName(RString 保険者名);

    public abstract TextBoxCode getHokenjaNotext();
}
