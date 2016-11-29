/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC8030001;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.core.kozafurikomi.FurikomiGyomunaiKubun;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8030001.DBC8030001MainDiv;
import jp.co.ndensan.reams.db.dbc.service.core.dbc8030001main.DBC8030001MainFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.ux.uxx.definition.mybatisprm.kozafurikomi.furikomiitakushakosei.FurikomiItakushaKoseiMapperParameter;
import jp.co.ndensan.reams.ux.uxx.divcontroller.entity.commonchilddiv.FurikomiBaitaiSakusei.FurikomiBaitaiSakuseiDiv;
import jp.co.ndensan.reams.ux.uxx.divcontroller.entity.commonchilddiv.FurikomiBaitaiSakusei.IFurikomiBaitaiSakuseiDiv;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;

/**
 * 振込データ媒体書き込みのHandlerです。
 *
 * @reamsid_L DBC-2180-080 x_liuwei
 */
public class DBC8030001MainHandler {

    private final DBC8030001MainDiv div;

    /**
     * コンストラクターです。
     *
     * @param div GemmenJisshiJokyoMainDiv
     */
    public DBC8030001MainHandler(DBC8030001MainDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化。
     */
    public void initialize() {
        RString メニューID = ResponseHolder.getMenuID();
        RString 振込単位 = DbBusinessConfig.get(ConfigNameDBC.振込単位, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 業務内区分 = RString.EMPTY;
        if (メニューID.equals(new RString("DBCMN43004"))) {
            if (振込単位.equals(new RString("1"))) {
                業務内区分 = FurikomiGyomunaiKubun.償還高額.getコード();
            } else {
                業務内区分 = FurikomiGyomunaiKubun.高額.getコード();
            }
        } else if (メニューID.equals(new RString("DBCMN54003"))) {
            if (振込単位.equals(new RString("1"))) {
                業務内区分 = FurikomiGyomunaiKubun.償還高額.getコード();
            } else {
                業務内区分 = FurikomiGyomunaiKubun.償還.getコード();
            }
        } else if (メニューID.equals(new RString("DBCMN63006"))) {
            業務内区分 = FurikomiGyomunaiKubun.高額合算.getコード();
        } else if (メニューID.equals(new RString("DBCMNL3004"))) {
            業務内区分 = FurikomiGyomunaiKubun.事業高額.getコード();
        } else if (メニューID.equals(new RString("DBCMNN2005"))) {
            業務内区分 = FurikomiGyomunaiKubun.事業高額合算.getコード();
        }
        div.getTxtShoriTaisho().setValue(FurikomiGyomunaiKubun.toValue(業務内区分).get名称());
        FurikomiItakushaKoseiMapperParameter parameter;
        parameter = FurikomiItakushaKoseiMapperParameter.createSelectByKeyParamAllowsNull(null, SubGyomuCode.DBC介護給付, 業務内区分, null, null, null);
        List<RString> list = new DBC8030001MainFinder().getGroupList(parameter);
        div.getCcdFurikomiBaitaiSakusei().setTestBaitaiSakuseiMode(FurikomiBaitaiSakuseiDiv.TestBaitaiSakuseiMode.通常);
        div.getCcdFurikomiBaitaiSakusei().setCommonChohyoSakuseiMode(FurikomiBaitaiSakuseiDiv.CommonChohyoSakuseiMode.送付書＿明細書);
        div.getCcdFurikomiBaitaiSakusei().setSelectButtonDisplayMode(FurikomiBaitaiSakuseiDiv.SelectButtonDisplayMode.表示しない);
        div.getTxtShoriTaisho().setReadOnly(true);
        div.getCcdFurikomiBaitaiSakusei().initialize(SubGyomuCode.DBC介護給付, list, IFurikomiBaitaiSakuseiDiv.UnyoHohoShokiHyoji.媒体,
                GyomuCode.DB介護保険, NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), RString.EMPTY);

    }
}
