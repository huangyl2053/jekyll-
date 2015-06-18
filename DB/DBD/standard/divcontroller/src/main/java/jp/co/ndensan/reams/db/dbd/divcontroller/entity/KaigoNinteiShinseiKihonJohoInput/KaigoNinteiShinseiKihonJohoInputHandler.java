/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.TokuteiShippei;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.shinsei.JukyuShinseiJiyu;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.HihokenshaKubun;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.KeyValueDataSource;

/**
 * 共有子Div「介護認定申請基本情報入力」の実装クラスです。
 *
 * @author N8235 船山 洋介
 */
public class KaigoNinteiShinseiKihonJohoInputHandler {

    private KaigoNinteiShinseiKihonJohoInputDiv div;
    private final RString NINTEI_RIYU_KEY = new RString("isExistKyakkaRiyu");
    private final RString SERVICE_SAKUJO_RIYU_KEY = new RString("isExistKyakkaRiyu");

    public KaigoNinteiShinseiKihonJohoInputHandler(KaigoNinteiShinseiKihonJohoInputDiv div) {
        this.div = div;
    }

    public void Initialize() {
        setDataSource();
        setTeikeiBunKey();
    }

    private void setDataSource() {

        div.getDdlHihokenshaKubun().setDataSource(createNinteiHihokenshaKubunKubunDarteSource());
        div.getDdlShinseiKubunHorei().setDataSource(createNinteiShinseiHoreiKubunDarteSource());
        div.getDdlShinseiKubunShinseiji().setDataSource(createNinteiShinseiShinseijiKubunDarteSource());
        div.getDdlShinseiShubetsu().setDataSource(createJukyuShinseiJiyuDataSource());
        div.getDdlTokuteiShippei().setDataSource(createNinteiTokuteiShippeiDarteSource());

    }

    private void setTeikeiBunKey() {
        div.setHdnNinteiRiyuTeikeibunKey(NINTEI_RIYU_KEY);
        div.setHdnServiceSakujoTeikeibunKey(SERVICE_SAKUJO_RIYU_KEY);
    }

    public void clear() {
        div.getTxtNinteiShinseRiyu().clearValue();
        div.getTxtServiceSakujo().clearValue();
        div.getTxtShinseiJokyo().clearValue();
        div.getTxtShinseiYMD().clearValue();

        div.getDdlHihokenshaKubun().setSelectedKey(DropDownList.BLANKLINE_KEY);
        div.getDdlShinseiKubunHorei().setSelectedKey(DropDownList.BLANKLINE_KEY);
        div.getDdlShinseiKubunShinseiji().setSelectedKey(DropDownList.BLANKLINE_KEY);
        div.getDdlShinseiShubetsu().setSelectedKey(DropDownList.BLANKLINE_KEY);
        div.getDdlTokuteiShippei().setSelectedKey(DropDownList.BLANKLINE_KEY);

        div.getChkKyuSochisha().setSelectedItemsByKey(new ArrayList<RString>());
        div.getChkShikakuShutokuMae().setSelectedItemsByKey(new ArrayList<RString>());

    }

    private List<KeyValueDataSource> createJukyuShinseiJiyuDataSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();

        for (JukyuShinseiJiyu jukyushinsei : JukyuShinseiJiyu.values()) {
            dataSource.add(new KeyValueDataSource(jukyushinsei.code(), jukyushinsei.toRString()));
        }

        return dataSource;
    }

    private List<KeyValueDataSource> createNinteiShinseiShinseijiKubunDarteSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (NinteiShinseiShinseijiKubunCode shinseiji : NinteiShinseiShinseijiKubunCode.values()) {
            dataSource.add(new KeyValueDataSource(shinseiji.code(), shinseiji.toRString()));

        }
        return dataSource;
    }

    private List<KeyValueDataSource> createNinteiShinseiHoreiKubunDarteSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (NinteiShinseiHoreiCode horei : NinteiShinseiHoreiCode.values()) {
            dataSource.add(new KeyValueDataSource(horei.code(), horei.toRString()));

        }
        return dataSource;
    }

    private List<KeyValueDataSource> createNinteiHihokenshaKubunKubunDarteSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (HihokenshaKubun horei : HihokenshaKubun.values()) {
            dataSource.add(new KeyValueDataSource(horei.code(), horei.toRString()));

        }
        return dataSource;
    }

    private List<KeyValueDataSource> createNinteiTokuteiShippeiDarteSource() {
        List<KeyValueDataSource> dataSource = new ArrayList<>();
        for (TokuteiShippei tokuteiShippei : TokuteiShippei.values()) {
            dataSource.add(new KeyValueDataSource(tokuteiShippei.code(), tokuteiShippei.toRString()));

        }
        return dataSource;
    }
}
