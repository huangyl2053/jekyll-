/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifukamanager;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * select徴収方法()取得Entity
 *
 * @reamsid_L DBB-0700-020 xuhao
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokutyoukariSannteiTyuushutuResultEntity implements Serializable {

    private FlexibleYear fukaNendo;
    private HihokenshaNo hihokenshaNo;
    private int rirekiNo;
    private RString choshuHoho4gatsu;
    private RString choshuHoho5gatsu;
    private RString choshuHoho6gatsu;
    private RString choshuHoho7gatsu;
    private RString choshuHoho8gatsu;
    private RString choshuHoho9gatsu;
    private RString choshuHoho10gatsu;
    private RString choshuHoho11gatsu;
    private RString choshuHoho12gatsu;
    private RString choshuHoho1gatsu;
    private RString choshuHoho2gatsu;
    private RString choshuHoho3gatsu;
    private RString choshuHohoYoku4gatsu;
    private RString choshuHohoYoku5gatsu;
    private RString choshuHohoYoku6gatsu;
    private RString choshuHohoYoku7gatsu;
    private RString choshuHohoYoku8gatsu;
    private RString choshuHohoYoku9gatsu;
    private RString kariNenkinNo;
    private RString kariNenkinCode;
    private RString kariHosokuM;
    private RString honNenkinNo;
    private RString honNenkinCode;
    private RString honHosokuM;
    private RString yokunendoKariNenkinNo;
    private RString yokunendoKariNenkinCode;
    private RString yokunendoKariHosokuM;
    private boolean iraiSohuzumiFlag;
    private boolean tsuikaIraiSohuzumiFlag;
    private YMDHMS tokuchoTeishiNichiji;
    private RString tokuchoTeishiJiyuCode;
    private Decimal choteigaku;
    private TsuchishoNo tsuchishoNo;
    private RString hokenryoDankai1;
    private RString hokenryoDankai2;
    private FlexibleDate seihoKaishiYMD;
    private FlexibleDate seihoHaishiYMD;
    private FlexibleDate ronenKaishiYMD;
    private FlexibleDate ronenHaishiYMD;
    private RString setaikazeiKubun;
    private RString kazeiKubun;
    private Decimal gokeiShotokuGaku;
    private Decimal nenkinShunyuGaku;

}
