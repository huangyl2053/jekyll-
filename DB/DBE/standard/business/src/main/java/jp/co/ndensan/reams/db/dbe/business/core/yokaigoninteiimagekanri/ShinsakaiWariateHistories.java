/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.yokaigoninteiimagekanri;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.basic.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.HanteiKekkaCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5502ShinsakaiWariateJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 審査会割当の履歴を扱います。
 */
public final class ShinsakaiWariateHistories implements java.io.Serializable {

    private final List<ShinsakaiWariateJoho> elements;

    ShinsakaiWariateHistories(List<DbT5502ShinsakaiWariateJohoEntity> entities) {
        List<ShinsakaiWariateJoho> list = new ArrayList<>();
        for (DbT5502ShinsakaiWariateJohoEntity entity : entities) {
            if (isInValid(entity)) {
                continue;
            }
            list.add(new ShinsakaiWariateJoho(entity));
        }
        Collections.sort(list, Comparators.OrderBy開催日.desc());
        this.elements = Collections.unmodifiableList(list);
    }

    //<editor-fold defaultstate="collapsed" desc="methods for constructor">
    private boolean isInValid(DbT5502ShinsakaiWariateJohoEntity entity) {
        return entity == null || !isValid(entity.getShinsakaiKaisaiYMD());
    }

    private enum Comparators implements Comparator<ShinsakaiWariateJoho> {

        OrderBy開催日 {
                    @Override
                    public int compare(ShinsakaiWariateJoho o1, ShinsakaiWariateJoho o2) {
                        return o1.get介護認定審査会開催年月日().compareTo(o2.get介護認定審査会開催年月日());
                    }
                };

        private Comparator desc() {
            return Collections.reverseOrder(this);
        }
    }
    //</editor-fold>

    /**
     * @return 最新の審査会への割り当て後に、審査会資料を作成済みの場合、{@code true}.
     */
    public boolean had審査会資料Published() {
        if (this.elements.isEmpty()) {
            return false;
        }
        return isValid(this.elements.get(0).get審査会資料作成年月日());
    }

    private static boolean isValid(FlexibleDate ymd) {
        return (ymd == null) ? false : ymd.isValid();
    }

    /**
     * @return 削除されることができるイメージの種類
     */
    public DeletableImages findDeletableImages() {
        return (this.elements.isEmpty())
                ? DeletableImages.全て
                : (this.elements.size() == 1)
                        ? onlyOnce(this.elements)
                        : moreThanOnce(this.elements);
    }

    //<editor-fold defaultstate="collapsed" desc="methods for findDeletableImages()">
    private static DeletableImages onlyOnce(List<ShinsakaiWariateJoho> elements) {
        ShinsakaiWariateJoho s = elements.get(0);
        if (s.getHanteiKekkaCode() == null) {
            return DeletableImages.全て;
        }
        return DeletableImages.無し;
    }

    private static DeletableImages moreThanOnce(List<ShinsakaiWariateJoho> elements) {
        ShinsakaiWariateJoho newest = elements.get(0);
        if (newest.getHanteiKekkaCode() != null) {
            return DeletableImages.無し;
        }
        ShinsakaiWariateJoho onceBefore = elements.get(1);
        HanteiKekkaCode beforeHanteiKekka = onceBefore.getHanteiKekkaCode();
        if (beforeHanteiKekka == null) {
            return DeletableImages.全て;
        }
        switch (beforeHanteiKekka) {
            case 再調査_意見書のみ:
                return DeletableImages.意見書関連のみ;
            case 再調査_調査のみ:
                return DeletableImages.調査票関連のみ;
            case 再調査_調査_意見書:
                return DeletableImages.その他資料のみ;
            default:
                return DeletableImages.全て;
        }
    }
    //</editor-fold>

    boolean isEmpty() {
        return this.elements.isEmpty();
    }
}
