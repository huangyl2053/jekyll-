/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigojigyosha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護事業者を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KaigoJigyoshaMapperParameter {

    private final KaigoJigyoshaNo jigyoshaNo;
    private final FlexibleDate yukoKaishiYMD;

    /**
     * コンストラクタです。
     *
     * @param KaigoJigyoshaNo jigyoshaNo
     * @param FlexibleDate yukoKaishiYMD
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KaigoJigyoshaMapperParameter(
            KaigoJigyoshaNo jigyoshaNo,
            FlexibleDate yukoKaishiYMD
    ) {

        this.jigyoshaNo = requireNonNull(jigyoshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        this.yukoKaishiYMD = requireNonNull(yukoKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param KaigoJigyoshaNo jigyoshaNo
     * @param FlexibleDate yukoKaishiYMD
     * @return 身体手帳検索パラメータ
     */
    public static KaigoJigyoshaMapperParameter createSelectByKeyParam(
            KaigoJigyoshaNo jigyoshaNo,
            FlexibleDate yukoKaishiYMD) {
        return new KaigoJigyoshaMapperParameter(jigyoshaNo, yukoKaishiYMD);
    }

}
