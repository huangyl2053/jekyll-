package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.jukyusha.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.core.tokuteishippei.TokuteiShippei;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ICommonChildDivBaseProperties;

/*
 * このコードはツールによって生成されました。
 *
 * @reamsid_L DBZ-1300-070 wangxiaodong
 */
public interface IKaigoNinteiShinseiKihonJohoInputDiv extends ICommonChildDivBaseProperties {

    void setInputMode(RString inputType);

    void initialize();

    void setRadShinseishoKubun(RString selectKey);

    void setTxtShinseiJokyo(RString value);

    void setTxtShinseiYMD(RDate value);

    void setShinseiShubetsu(JukyuShinseiJiyu value);

    void setShinseiKubunShinseiji(NinteiShinseiShinseijiKubunCode value);

    void setShinseiKubunHorei(NinteiShinseiHoreiCode value);

    void setShisho(ShishoCode shishoCode);

    void setKyuSochisha(List<RString> selectedKeys);

    void setHihokenshaKubun(HihokenshaKubunCode value);

    void setChkShikakuShutokuMae(List<RString> selectedKeys);

    void setTokuteiShippei(TokuteiShippei value);

    void setServiceSakujoTeikeibun(RString teikeibun);

    void setNinteiShinseRiyuTeikeibun(RString teikeibun);

    KaigoNinteiShinseiKihonJohoInputDiv getKaigoNinteiShinseiKihonJohoInputDiv();
}
