/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.definition.mybatisprm.kaigojigyosha;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 介護事業者を特定するためのMyBatis用パラメータクラスです。
 */
@lombok.Getter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class KaigoJigyoshaMapperParameter {

    private final JigyoshaNo jigyoshaNo;
    private final List<JigyoshaNo> jigyoshaNoList;
    private final FlexibleDate yukoKaishiYMD;

    /**
     * コンストラクタです。
     *
     * @param JigyoshaNo jigyoshaNo
     * @param FlexibleDate yukoKaishiYMD
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    private KaigoJigyoshaMapperParameter(
            JigyoshaNo jigyoshaNo,
            List<JigyoshaNo> jigyoshaNoList,
            FlexibleDate yukoKaishiYMD
    ) {

        this.jigyoshaNo = requireNonNull(jigyoshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        this.jigyoshaNoList = requireNonNull(jigyoshaNoList, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号List"));
        this.yukoKaishiYMD = requireNonNull(yukoKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

    }

    /**
     * キー検索用のパラメータを生成します。事業者Noを一意に指定するため、
     *
     * @param jigyoshaNo JigyoshaNo
     * @param yukoKaishiYMD FlexibleDate
     * @return 身体手帳検索パラメータ
     */
    public static KaigoJigyoshaMapperParameter createSelectByKeyParam(
            JigyoshaNo jigyoshaNo,
            FlexibleDate yukoKaishiYMD) {
        return new KaigoJigyoshaMapperParameter(jigyoshaNo, new ArrayList<JigyoshaNo>(), yukoKaishiYMD);
    }

    /**
     * キー検索用のパラメータを生成します。
     *
     * @param jigyoshaNoList JigyoshaNoList
     * @param yukoKaishiYMD FlexibleDate
     * @return 身体手帳検索パラメータ
     */
    public static KaigoJigyoshaMapperParameter createSelectByKeyParam(
            List<JigyoshaNo> jigyoshaNoList,
            FlexibleDate yukoKaishiYMD) {

        JigyoshaNo settingJigyoshaNo = JigyoshaNo.EMPTY;
        List<JigyoshaNo> settingJigyoshaNoList = new ArrayList<>();

        if (jigyoshaNoList != null && !jigyoshaNoList.isEmpty()) {
            settingJigyoshaNo = jigyoshaNoList.get(0);
            settingJigyoshaNoList = jigyoshaNoList;
        }

        return new KaigoJigyoshaMapperParameter(settingJigyoshaNo, settingJigyoshaNoList, yukoKaishiYMD);
    }

}
