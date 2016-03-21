/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakayijidouwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会自動割付RelateEntityクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
@Setter
public class ShinsaKayiJidouWaritsukeRelateEntity {

    private RString shinsakaiKaisaiNo;
    private RString 審査会名称;
    private RString gogitaiMei;
    private boolean gogitaiSeishinkaSonzaiFlag;
    private RString shinsakaiKaisaiBashoName;
    private RString shinsakaiKaisaiYoteiYMD;
    private RString shinsakaiKaishiYoteiTime;
    private RString shinsakaiShuryoYoteiTime;
    private RString shinsakaiJidoWariateTeiin;
    private RString shinsakaiWariateZumiNinzu;
    private RString ShinsakaiShinchokuJokyo;
    private boolean gogitaiDummyFlag;
}
