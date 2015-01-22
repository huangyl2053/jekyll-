/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.ShichosonShikibetsuID;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 市町村セキュリティの情報を保持するクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShichosonSecurity {

    private final boolean 介護導入;
    private final ShichosonShikibetsuID 市町村識別ID;
    private final LasdecCode 市町村コード;

    /**
     * コンストラクタです。
     *
     * @param 介護導入 介護導入
     * @param 市町村識別ID 市町村識別ID
     * @param 市町村コード 市町村コード
     */
    public ShichosonSecurity(boolean 介護導入, ShichosonShikibetsuID 市町村識別ID, LasdecCode 市町村コード) {
        this.介護導入 = 介護導入;
        this.市町村識別ID = 市町村識別ID;
        this.市町村コード = 市町村コード;
    }

    /**
     * 介護業務が導入済かどうかを判定します。
     *
     * @return 導入済の場合はtrueを、未導入の場合はfalseを返します。
     */
    public boolean is介護導入() {
        return 介護導入;
    }

    /**
     * 市町村識別IDを返します。
     *
     * @return 市町村識別ID。介護業務未導入の場合はnullを返します。
     */
    public ShichosonShikibetsuID get市町村識別ID() {
        return 介護導入 ? 市町村識別ID : null;
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード。介護業務未導入の場合はnullを返します。
     */
    public LasdecCode get市町村コード() {
        return 介護導入 ? 市町村コード : null;
    }
}
