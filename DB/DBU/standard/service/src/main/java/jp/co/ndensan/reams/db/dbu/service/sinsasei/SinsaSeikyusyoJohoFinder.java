/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.sinsasei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.SinsaSeikyusyoJohoModel;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7001FufukuMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7001FufukuMoshitateDac;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 審査請求書登録_一覧情報の取得処理。
 */
public class SinsaSeikyusyoJohoFinder {

    private final DbT7001FufukuMoshitateDac fufukumoshitatedac;

    /**
     * コンストラクタ
     *
     */
    public SinsaSeikyusyoJohoFinder() {
        this.fufukumoshitatedac = InstanceProvider.create(DbT7001FufukuMoshitateDac.class);
    }

    /**
     * クラスをcreateメソッドです。
     *
     * @return 一覧情報の取得処理するクラス
     */
    public static SinsaSeikyusyoJohoFinder createInstance() {
        return InstanceProvider.create(SinsaSeikyusyoJohoFinder.class);
    }

    /**
     * 一覧情報データを返します。
     *
     * @param shikibetsuCode 識別コード
     * @param genshobunsHihokennshaNo 原処分被保険者番号
     * @return List<SinsaSeikyusyoJohoModel>
     */
    public List<SinsaSeikyusyoJohoModel> getSinsaSeikyusyoJohoList(ShikibetsuCode shikibetsuCode, HihokenshaNo genshobunsHihokennshaNo) {
        List<SinsaSeikyusyoJohoModel> businessList = new ArrayList<>();
        List<DbT7001FufukuMoshitateEntity> dbT7001FufukuMoshitateEntity = fufukumoshitatedac.select一覧情報取得(shikibetsuCode, genshobunsHihokennshaNo);
        for (DbT7001FufukuMoshitateEntity fufukuMoshitateEntity : dbT7001FufukuMoshitateEntity) {
            businessList.add(new SinsaSeikyusyoJohoModel(fufukuMoshitateEntity));
        }

        return businessList;
    }
}
