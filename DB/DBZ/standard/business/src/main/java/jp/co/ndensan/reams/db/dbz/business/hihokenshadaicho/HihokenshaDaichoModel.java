/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.hihokenshadaicho;

import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ShoriTimestamp;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 *
 * @author n8300　姜井図
 */
public class HihokenshaDaichoModel {

    private DbT1001HihokenshaDaichoEntity entity;
    /**
     * コンストラクタ
     *
     * @param createEntity DbT1001HihokenshaDaichoEntity
     */
//    public HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntity createEntity) {
    public HihokenshaDaichoModel(DbT1001HihokenshaDaichoEntity createEntity) {
        entity = createEntity;
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    HihokenshaDaichoModel() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    void set市町村コード(LasdecCode shichosonCode) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    void set被保険者番号(HihokenshaNo hihokenshaNo) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    void set処理日時(ShoriTimestamp shoriTimestamp) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    DbT1001HihokenshaDaichoEntity getEntity() {
        return entity;
//        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    Object get適用年月日() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    Object get資格取得年月日() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    Object get処理日時() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    Object get資格変更年月日() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    Object get市町村コード() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    Object get資格取得事由() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * get被保険者番号
     *
     * @return Object
     */
    public Object get被保険者番号() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * set資格取得年月日
     *
     * @param matchDate FlexibleDate
     */
    public void set資格取得年月日(FlexibleDate matchDate) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * set適用年月日
     *
     * @param tekiyoDate1 FlexibleDate
     */
    public void set適用年月日(FlexibleDate tekiyoDate1) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * set解除年月日
     *
     * @param empty FlexibleDate
     */
    public void set解除年月日(FlexibleDate empty) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * set資格変更年月日
     *
     * @param min FlexibleDate
     */
    public void set資格変更年月日(FlexibleDate min) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * set資格喪失年月日
     *
     * @param 喪失日 FlexibleDate
     */
    public void set資格喪失年月日(FlexibleDate 喪失日) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }
}
