/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.definition.tsuchishohakkogoidosha;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoChushutsuKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.idoruiseki.ShikibetsuTaishoIdoSearchKey;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JutogaiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import lombok.Getter;

/**
 * 対象データの抽出 paramter
 */
@Getter
public class TsuchishohakkogoidoshaParamter extends ShikibetsuTaishoIdoSearchKey {

    private static final List<JukiIdoJiyu> 空のコード = new ArrayList<>();
    private static final List<JutogaiIdoJiyu> 空のコード1 = new ArrayList<>();
    private static final List<JuminShubetsu> 空のコード3 = new ArrayList<>();
    private static final List<JuminJotai> 空のコード4 = new ArrayList<>();
    private final ReportId 帳票ID;
    private final YMDHMS 帳票作成日時;

    /**
     * TsuchishohakkogoidoshaParamter
     *
     * @param searchKey
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     */
    TsuchishohakkogoidoshaParamter(ShikibetsuTaishoIdoSearchKey searchKey, ReportId 帳票ID, YMDHMS 帳票作成日時) {
        super(ShikibetsuTaishoIdoChushutsuKubun.異動処理日時と異動事由で異動前後を抽出, 帳票作成日時.getRDateTime(), RDate.getNowDateTime(),
                true, 空のコード, 空のコード1, null, null, 空のコード3, 空のコード4, null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null);
        this.帳票ID = 帳票ID;
        this.帳票作成日時 = 帳票作成日時;
    }

    /**
     * コンストラクタです
     *
     * @param searchKey
     * @param 帳票ID
     * @param 帳票作成日時
     * @return
     */
    public static TsuchishohakkogoidoshaParamter createSelectByKeyParam(ShikibetsuTaishoIdoSearchKey searchKey,
            ReportId 帳票ID, YMDHMS 帳票作成日時) {
        return new TsuchishohakkogoidoshaParamter(searchKey, 帳票ID, 帳票作成日時);
    }

}
