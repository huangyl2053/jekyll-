/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteikekktesuchi;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;

/**
 * 要介護認定結果通知情報ビジネスクラスです。
 */
public class YouKaiGoNinTeiKekTesuChi  implements Serializable {

    private YouKaiGoNinTeiKekTesuChiRelateEntity entity;
    
     /**
     * コンストラクタです。<br/>
     * 要介護認定結果通知情報ビジネスの新規作成時に使用します。
     *
     * @param relateEntity 要介護認定結果情報RelateEntityクラスです。
     */
    public YouKaiGoNinTeiKekTesuChi(YouKaiGoNinTeiKekTesuChiRelateEntity relateEntity) {
        requireNonNull(relateEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報RelateEntity"));
        this.entity = relateEntity;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
