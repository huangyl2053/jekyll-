/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ninnteichousairai;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NinteichosaIraiJoho;

/**
 * 認定調査依頼項目を管理するクラスです。
 */
public class NinteichosaIraiJohoRelateBusiness {

    private final List<NinteichosaIraiJoho> ninteichosaIraiJohoList;
    private final List<NinteiKanryoJoho> ninteiKanryoJohoList;

    /**
     * コンストラクタです。
     *
     * @param ninteichosaIraiJohoList List<NinteichosaIraiJoho>
     * @param ninteiKanryoJohoList List<NinteiKanryoJoho>
     */
    public NinteichosaIraiJohoRelateBusiness(List<NinteichosaIraiJoho> ninteichosaIraiJohoList, List<NinteiKanryoJoho> ninteiKanryoJohoList) {
        this.ninteichosaIraiJohoList = ninteichosaIraiJohoList;
        this.ninteiKanryoJohoList = ninteiKanryoJohoList;
    }

    /**
     * 認定調査依頼情報リストを取得します。
     *
     * @return 認定調査依頼情報リスト
     */
    public List<NinteichosaIraiJoho> getNinteichosaIraiJohoList() {
        return ninteichosaIraiJohoList;
    }

    /**
     * 要介護認定完了情報リストを取得します。
     *
     * @return 要介護認定完了情報リスト
     */
    public List<NinteiKanryoJoho> getNinteiKanryoJohoList() {
        return ninteiKanryoJohoList;
    }
}
