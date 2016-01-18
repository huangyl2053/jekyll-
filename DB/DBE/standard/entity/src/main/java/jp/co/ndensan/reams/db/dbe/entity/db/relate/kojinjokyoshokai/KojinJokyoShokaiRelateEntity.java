/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate.kojinjokyoshokai;

import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定個人状況照会用Entityクラスです。
 * 
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class KojinJokyoShokaiRelateEntity {
    private FlexibleDate ninteichosaIraiYoteiYMD;				
    private FlexibleDate ninteichosaYoteiYMD;					
    private FlexibleDate ikenshoSakuseiIraiYoteiYMD;			
    private FlexibleDate ikenshoTorokuYoteiYMD;					
    private FlexibleDate ichijiHanteiYoteiYMD;					
    private FlexibleDate ninteiShinsakaiWariateYoteiYMD;		
    private FlexibleDate ninteiShinsakaiYoteiYMD;				
    private FlexibleDate ninteichosaIraiKanryoYMD;				
    private FlexibleDate ninteichosaKanryoYMD;					
    private FlexibleDate ikenshoSakuseiIraiKanryoYMD;			
    private FlexibleDate ikenshoTorokuKanryoYMD;				
    private FlexibleDate ichijiHanteiKanryoYMD;					
    private FlexibleDate maskingKanryoYMD;						
    private FlexibleDate ninteiShinsakaiWariateKanryoYMD;		
    private FlexibleDate ninteiShinsakaiKanryoYMD;				
    private FlexibleDate ninteiShinseiYMD;						
    private Code ninteiShinseiShinseijiKubunCode;		
    private Code ninteiShinseiHoreiKubunCode;			
    private Code nijiHanteiYokaigoJotaiKubunCode;		
    private FlexibleDate nijiHanteiNinteiYukoKaishiYMD;			
    private FlexibleDate nijiHanteiNinteiYukoShuryoYMD;			
    private int nijiHanteiNinteiYukoKikan;				
    private RString shienShinseiKubun;						
    private Code nigoTokuteiShippeiCode;				
    private boolean johoteikyoDoiFlag;						
    private Code ichijiHanteiKekkaCode;					
    private FlexibleDate shinsakaiKaisaiYMD;					
    private Code shoriJotaiKubun;
}
