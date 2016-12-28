/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.centertransmission;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * センター送信データ作成のMyBatis用パラメータクラスです。
 *
 * @reamsid_L DBE-1520-020 wangxiaodong
 */
@Setter
@Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CenterTransmissionMybitisParamter implements IMyBatisParameter {

    private RString 通常;
    private RString 延期;
    private List<RString> shinseishoKanriNoList;
    private List<RString> shinseijiKubunCodeList;
    private boolean isMiSyutsuryokuNomi;
    private boolean isTennyuShiboSyuturyoku;
    private RString nijiHanteiKaishiYMD;
    private RString nijiHanteiShuryoYMD;
    private boolean isNijiHanteiKaishiYMDEmpty;
    private boolean isNijiHanteiShuryoYMDEmpty;
    private RString gaikyoChosaTextImageKubun;
}
