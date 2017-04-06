/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaijoho;

import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoIdentifier;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * 合議体情報を保存する機能を持つことを表します。
 */
public interface IGogitaiJohoPreserver {

    /**
     * 指定の合議体情報を保存します。
     *
     * @param gogitaiJohoModel
     */
    void save(Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel);
}
