/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo;

import java.util.List;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者基本情報のMybatisParameterクラスです。
 *
 * @reamsid_L DBU-4880-050 wangxiaodong
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class JukyushaKihonJohoMybatisParameter implements IMyBatisParameter {

    private RDateTime taishoKaishiTimestamp;
    private RDateTime taishoShuryoTimestamp;
    private RString yukoMukoKubun;
    private boolean isShinkiIdo;
    private RString teikyoKubun_SonotaError;
    private RString teikyoKubun_KojinBango;
    private RString tokuteiKojinJohoMeiCode;
    private List<RString> tokuteiKojinJohoMeiCodeList;
    private RString dataSetRecordKey;
    private RString hanNo;
    private RString tempTableName;
    private RString psmShikibetsuTaisho;

}
