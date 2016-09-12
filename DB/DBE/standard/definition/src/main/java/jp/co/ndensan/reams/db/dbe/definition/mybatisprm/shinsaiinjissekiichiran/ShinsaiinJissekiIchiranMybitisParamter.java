/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsaiinjissekiichiran;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranKey;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;
import lombok.Setter;

/**
 * 介護認定審査会委員報酬実績のデータ取得パラメータクラスです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
@Getter
@Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public final class ShinsaiinJissekiIchiranMybitisParamter implements IMyBatisParameter {

    private final boolean batchFlag;
    private final boolean 審査会開催日FROMFlag;
    private final FlexibleDate 審査会開催日FROM;
    private final boolean 審査会開催日TOFlag;
    private final FlexibleDate 審査会開催日TO;
    private final boolean 件数Flag;
    private final int 件数;
    private final boolean gamenFlag;
    private final List<ShinsaiinJissekiIchiranKey> keyJoho;

    private ShinsaiinJissekiIchiranMybitisParamter(boolean batchFlag,
            boolean 審査会開催日FROMFlag,
            FlexibleDate 審査会開催日FROM,
            boolean 審査会開催日TOFlag,
            FlexibleDate 審査会開催日TO,
            boolean 件数Flag,
            int 件数,
            boolean gamenFlag,
            List<ShinsaiinJissekiIchiranKey> keyJoho) {
        this.batchFlag = batchFlag;
        this.審査会開催日FROMFlag = 審査会開催日FROMFlag;
        this.審査会開催日FROM = 審査会開催日FROM;
        this.審査会開催日TOFlag = 審査会開催日TOFlag;
        this.審査会開催日TO = 審査会開催日TO;
        this.件数Flag = 件数Flag;
        this.件数 = 件数;
        this.gamenFlag = gamenFlag;
        this.keyJoho = keyJoho;
    }

    /**
     * 審査会委員実績データの取得のパラメータを作成します。
     *
     * @param batchFlag batchFlag
     * @param 審査会開催日FROM 審査会開催日FROM
     * @param 審査会開催日TO 審査会開催日TO
     * @param 最大表示件数 最大表示件数
     * @return 審査会委員実績データの取得パラメータ
     */
    public static ShinsaiinJissekiIchiranMybitisParamter createParamter(boolean batchFlag,
            FlexibleDate 審査会開催日FROM,
            FlexibleDate 審査会開催日TO,
            RString 最大表示件数) {
        return new ShinsaiinJissekiIchiranMybitisParamter(batchFlag,
                !審査会開催日FROM.isEmpty(),
                審査会開催日FROM,
                !審査会開催日TO.isEmpty(),
                審査会開催日TO,
                !RString.isNullOrEmpty(最大表示件数),
                Integer.parseInt(最大表示件数.toString()),
                true,
                null);
    }

    /**
     * 介護認定審査会委員報酬集計表データの取得のパラメータを作成します。
     *
     * @param batchFlag batchFlag
     * @param 審査会開催日FROM 審査会開催日FROM
     * @param 審査会開催日TO 審査会開催日TO
     * @param keyJoho 介護認定審査会委員報酬集計表のキー情報
     * @return 介護認定審査会委員報酬集計表データの取得パラメータ
     */
    public static ShinsaiinJissekiIchiranMybitisParamter createParamter(boolean batchFlag,
            FlexibleDate 審査会開催日FROM,
            FlexibleDate 審査会開催日TO,
            List<ShinsaiinJissekiIchiranKey> keyJoho) {
        return new ShinsaiinJissekiIchiranMybitisParamter(batchFlag,
                !審査会開催日FROM.isEmpty(),
                審査会開催日FROM,
                !審査会開催日TO.isEmpty(),
                審査会開催日TO,
                false,
                0,
                false,
                keyJoho);
    }
}
