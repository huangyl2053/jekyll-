/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbe.definition.ChosaItakuKubun;
import jp.co.ndensan.reams.ur.urf.business.IJigyosha;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査委託先のクラスです
 * 
 * @author N1013
 */
public class NinteichosaItakusaki {
    
    private final RString 市町村コード;
    private final IJigyosha 事業者;
    private final KaigoJigyoshaNo 介護事業者番号;
    private final boolean 有効区分;
    private final ChosaItakuKubun 調査委託区分;
    private final int 割付定員;
    private final RString 割付地区;
    
    
    /**
     * 
     * @param 市町村コード
     * @param 事業者
     * @param 介護事業者番号
     * @param 有効区分
     * @param 調査委託区分
     * @param 割付定員
     * @param 割付地区
     * @throws NullPointerException 
     */
    public NinteichosaItakusaki(RString 市町村コード,IJigyosha 事業者,KaigoJigyoshaNo 介護事業者番号,
                                   boolean 有効区分,ChosaItakuKubun 調査委託区分,
                                   int 割付定員,RString 割付地区) throws NullPointerException {
        Objects.requireNonNull(市町村コード, Messages.E00003.replace("市町村コード", "認定調査委託先").getMessage());
        Objects.requireNonNull(事業者, Messages.E00003.replace("事業者", "認定調査委託先").getMessage());
        Objects.requireNonNull(介護事業者番号, Messages.E00003.replace("介護事業者番号", "認定調査委託先").getMessage());
        Objects.requireNonNull(有効区分, Messages.E00003.replace("介護保険事業者の状況", "認定調査委託先").getMessage());

        this.市町村コード = 市町村コード;
        this.事業者 = 事業者;
        this.介護事業者番号 = 介護事業者番号;
        this.有効区分 = 有効区分;
        this.調査委託区分 = 調査委託区分;
        this.割付定員 = 割付定員;
        this.割付地区 = 割付地区;
    }
    
    /**
     * 事業者コードを取得します
     * 
     * @return 事業者コード
     */
    public IJigyosha getJigyosya() {
        return 事業者;
    }
    
    /**
     * 市町村コードを取得します
     * 
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return 市町村コード;
    }
            
    /**
     * 介護事業者番号を取得します
     * 
     * @return 介護事業者番号 
     */
    public KaigoJigyoshaNo getKaigoJigyoshaNo(){
        return 介護事業者番号;
    }
    
    /**
     * 介護事業者状況を判定します
     * 
     * @return 介護事業者状況 
     */
    public boolean is有効(){
        return 有効区分;
    }
    
    /**
     * 調査委託区分を取得します
     * 
     * @return 調査委託区分 
     */
    public ChosaItakuKubun getChosaItakuKubun(){
        return 調査委託区分;
    }
    
    /**
     * 割付定員を取得します
     * 
     * @return 割付定員
     */
    public int getWaritsukeTeiin(){
        return 割付定員;
    }
    
    /**
     * 割付地区を取得します
     * 
     * @return 割付地区
     */
    public RString getWaritsukeChiku(){
        return 割付地区;
    }
}
