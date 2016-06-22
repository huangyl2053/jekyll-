/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.mapper.relate.jogaishinsainjoho;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.jogaishinsainjoho.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 除外審査員情報データ取得してクラスです。
 *
 * @reamsid_L DBZ-1300-040 dongyabin
 */
public interface IJogaiShinsainJohoMapper {

    /**
     * 審査会委員一覧検索して審査会委員情報を取得します。
     *
     * @param shinseishoKanriNo 申請書管理番号
     * @return 審査会委員情報
     */
    List<ShinsakaiIinJohoRelateEntity> getShinsakaiIinJoho(RString shinseishoKanriNo);

    /**
     * 審査会委員コードより審査会委員情報を取得します。
     *
     * @param shinsakaiIinCode 審査会委員コード
     * @return 審査会委員情報
     */
    List<ShinsakaiIinJohoRelateEntity> getShinsakaiIinJohoByCode(RString shinsakaiIinCode);
}
