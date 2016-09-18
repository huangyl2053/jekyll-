/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.basic;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * IDbV2502KaigoShotokuMapper のパラメータ
 */
public class KaigoShotokuMapperParameter {

    private final FlexibleYear shiteiNendo;
    private final YMDHMS shiteiShoriYMDHMS;
    private final List<ShikibetsuCode> shikibetsuCodeList;

    public KaigoShotokuMapperParameter(FlexibleYear shiteiNendo, YMDHMS shiteiShoriYMDHMS, List<ShikibetsuCode> shikibetsuCodeList) {
        this.shiteiNendo = shiteiNendo;
        this.shiteiShoriYMDHMS = shiteiShoriYMDHMS;
        this.shikibetsuCodeList = new ArrayList<>(shikibetsuCodeList);
    }

    /**
     * 指定年度を返します。
     *
     * @return 指定年度
     */
    public FlexibleYear getShiteiNendo() {
        return shiteiNendo;
    }

    /**
     * 指定処理日時を返します。
     *
     * @return 指定処理日時
     */
    public YMDHMS getShiteiShoriYMDHMS() {
        return shiteiShoriYMDHMS;
    }

    /**
     * 識別コードのリストを返します。
     *
     * @return 識別コードのリスト
     */
    public List<ShikibetsuCode> getShikibetsuCodeList() {
        return new ArrayList<>(shikibetsuCodeList);
    }
}
