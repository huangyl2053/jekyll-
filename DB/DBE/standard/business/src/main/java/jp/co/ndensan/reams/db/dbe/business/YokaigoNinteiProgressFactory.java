/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business;

import java.util.EnumMap;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 要介護認定進捗情報の年月日を変更して生成するクラスです。
 *
 * @author N8187 久保田 英男
 */
public class YokaigoNinteiProgressFactory {

    /**
     * 要介護認定進捗情報の変更する年月日を表す列挙型です。
     */
    public enum ParticularDates {

        /**
         * 認定申請情報登録年月日
         */
        認定申請情報登録年月日,
        /**
         * 認定延期通知発行年月日
         */
        認定延期通知発行年月日,
        /**
         * 要介護認定一次判定情報抽出年月日
         */
        要介護認定一次判定情報抽出年月日,
        /**
         * 依頼情報データ送信年月日
         */
        依頼情報データ送信年月日,
        /**
         * 認定調査依頼完了年月日
         */
        認定調査依頼完了年月日,
        /**
         * 認定調査完了年月日
         */
        認定調査完了年月日,
        /**
         * 主治医意見書作成依頼完了年月日
         */
        主治医意見書作成依頼完了年月日,
        /**
         * 主治医意見書登録完了年月日
         */
        主治医意見書登録完了年月日,
        /**
         * 要介護認定一次判定完了年月日
         */
        要介護認定一次判定完了年月日,
        /**
         * 要介護認定1_5次判定完了年月日
         */
        要介護認定1_5次判定完了年月日,
        /**
         * 認定審査会割当完了年月日
         */
        認定審査会割当完了年月日,
        /**
         * 認定審査会完了年月日
         */
        認定審査会完了年月日,
        /**
         * センター送信年月日
         */
        センター送信年月日;
    }
    private final YokaigoNinteiProgress progress;
    private Map<ParticularDates, FlexibleDate> mapOfDateItems;

    /**
     * コンストラクタです。
     *
     * @param progress 要介護認定進捗情報
     */
    public YokaigoNinteiProgressFactory(YokaigoNinteiProgress progress) {
        this.progress = requireNonNull(progress, Messages.E00001.replace("要介護認定進捗情報").getMessage());
        mapOfDateItems = toMapOnlyDateItems();
    }

    /**
     * 要介護認定進捗情報の変更する年月日を指定し、年月日を変更した要介護認定進捗情報を生成して返します。
     *
     * @param datesItem 変更する年月日
     * @param date 年月日
     * @return 要介護認定進捗情報
     */
    public YokaigoNinteiProgress createYokaigoninteiPorgressWith(ParticularDates datesItem, FlexibleDate date) {
        mapOfDateItems.put(datesItem, date);
        return toYokaigoninteiProgress(mapOfDateItems);
    }

    private YokaigoNinteiProgress toYokaigoninteiProgress(Map<ParticularDates, FlexibleDate> map) {
        return new YokaigoNinteiProgress(
                progress.get申請書管理番号(),
                map.get(ParticularDates.認定申請情報登録年月日),
                progress.has認定延期通知発行に対する同意有無(),
                map.get(ParticularDates.認定延期通知発行年月日),
                progress.get認定延期通知発行回数(),
                progress.get要介護認定延期理由(),
                map.get(ParticularDates.要介護認定一次判定情報抽出年月日),
                map.get(ParticularDates.依頼情報データ送信年月日),
                map.get(ParticularDates.認定調査依頼完了年月日),
                map.get(ParticularDates.認定調査完了年月日),
                map.get(ParticularDates.主治医意見書作成依頼完了年月日),
                map.get(ParticularDates.主治医意見書登録完了年月日),
                map.get(ParticularDates.要介護認定一次判定完了年月日),
                map.get(ParticularDates.要介護認定1_5次判定完了年月日),
                map.get(ParticularDates.認定審査会割当完了年月日),
                map.get(ParticularDates.認定審査会完了年月日),
                map.get(ParticularDates.センター送信年月日));
    }

    private Map<ParticularDates, FlexibleDate> toMapOnlyDateItems() {
        Map<ParticularDates, FlexibleDate> map = new EnumMap<>(ParticularDates.class);
        map.put(ParticularDates.認定申請情報登録年月日, progress.get認定申請情報登録年月日());
        map.put(ParticularDates.認定延期通知発行年月日, progress.get認定延期通知発行年月日());
        map.put(ParticularDates.要介護認定一次判定情報抽出年月日, progress.get要介護認定一次判定情報抽出年月日());
        map.put(ParticularDates.依頼情報データ送信年月日, progress.get依頼情報データ送信年月日());
        map.put(ParticularDates.認定調査依頼完了年月日, progress.get認定調査依頼完了年月日());
        map.put(ParticularDates.認定調査完了年月日, progress.get認定調査完了年月日());
        map.put(ParticularDates.主治医意見書作成依頼完了年月日, progress.get主治医意見書作成依頼完了年月日());
        map.put(ParticularDates.主治医意見書登録完了年月日, progress.get主治医意見書登録完了年月日());
        map.put(ParticularDates.要介護認定一次判定完了年月日, progress.get要介護認定一次判定完了年月日());
        map.put(ParticularDates.要介護認定1_5次判定完了年月日, progress.get要介護認定1_5次判定完了年月日());
        map.put(ParticularDates.認定審査会割当完了年月日, progress.get認定審査会割当完了年月日());
        map.put(ParticularDates.認定審査会完了年月日, progress.get認定審査会完了年月日());
        map.put(ParticularDates.センター送信年月日, progress.getセンター送信年月日());
        return map;
    }
}
