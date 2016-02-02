/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsakaiiinwaritsuke;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 審査会開催予定情報RelateEntityクラスです。
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class ShinsakaiKaisaiYoteiJohoRelateEntity {

    private RString gogitaiMei;
    private boolean gogitaiSeishinkaSonzaiFlag;
    private boolean gogitaiDummyFlag;
    private RString shinsakaiKaishiYoteiTime;
    private RString shinsakaiShuryoYoteiTime;
    private RString shinsakaiKaisaiYoteiYMD;
    private int shinsakaiYoteiTeiin;
    private RString shinsakaiKaisaiBashoName;
}
