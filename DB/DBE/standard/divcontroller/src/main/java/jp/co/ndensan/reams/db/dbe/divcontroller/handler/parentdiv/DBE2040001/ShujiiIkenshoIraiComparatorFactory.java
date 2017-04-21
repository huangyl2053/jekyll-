package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE2040001;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Comparator;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2040001.dgNinteiTaskList_Row;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * コンパレータを作成するクラスです。
 * @author n8438
 */
public class ShujiiIkenshoIraiComparatorFactory {
    
    private static final RString 取得メソッド = new RString("get");
    
    /**
     * 列名とboolean昇順・降順からコンパレータを返します。
     * @param colName 行の英字名
     * @param isAsc 昇順・降順
     * @return Comparator Comparator
     */
    public Comparator<dgNinteiTaskList_Row> getNinteiTaskListComparator(RString colName, boolean isAsc) {
        ShujiiIkenshoIraiColunmData columnData = ShujiiIkenshoIraiColunmData.getSortKey(colName);
        switch (columnData.getCellType()) {
            case String :
            default :
                return new ShujiiIkenshoIraiStringComparator(colName, isAsc);
            
            case TextBoxDate :
                return new ShujiiIkenshoIraiTextBoxDateComparator(colName, isAsc);
                
            case TextBoxNum :
                return new ShujiiIkenshoIraiTextBoxNumComparator(colName, isAsc);
        }
    }

    private class ShujiiIkenshoIraiStringComparator implements Comparator<dgNinteiTaskList_Row> {

        private final RString colName;
        private final boolean isAsc;

        ShujiiIkenshoIraiStringComparator(RString colName, boolean isAsc) {
            this.colName = colName;
            this.isAsc = isAsc;
        }

        @Override
        public int compare(dgNinteiTaskList_Row o1, dgNinteiTaskList_Row o2) {
            try {
                RStringBuilder methodName = new RStringBuilder();
                methodName.append(colName).replace(0, 1, methodName.substring(0, 1).toUpperCase()).insert(0, 取得メソッド);
                Method method = dgNinteiTaskList_Row.class.getMethod(methodName.toString());
                RString s1 = (RString) (method.invoke(o1));
                RString s2 = (RString) (method.invoke(o2));

                return isAsc ? s1.compareTo(s2) : s2.compareTo(s1);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                return 0;
            }
        }
    }

    private class ShujiiIkenshoIraiTextBoxNumComparator implements Comparator<dgNinteiTaskList_Row> {
        private final RString colName;
        private final boolean isAsc;

        ShujiiIkenshoIraiTextBoxNumComparator(RString colName, boolean isAsc) {
            this.colName = colName;
            this.isAsc = isAsc;
        }

        @Override
        public int compare(dgNinteiTaskList_Row o1, dgNinteiTaskList_Row o2) {
            try {
                RStringBuilder methodName = new RStringBuilder();
                methodName.append(colName).replace(0, 1, methodName.substring(0, 1).toUpperCase()).insert(0, 取得メソッド);
                Method method = dgNinteiTaskList_Row.class.getMethod(methodName.toString());
                Decimal d1 = ((TextBoxNum) (method.invoke(o1))) == null ? Decimal.ZERO : ((TextBoxNum) (method.invoke(o1))).getValue();
                Decimal d2 = ((TextBoxNum) (method.invoke(o2))) == null ? Decimal.ZERO : ((TextBoxNum) (method.invoke(o2))).getValue();

                return isAsc ? d1.compareTo(d2) : d2.compareTo(d1);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                return 0;
            }
        }
    }

    private class ShujiiIkenshoIraiTextBoxDateComparator implements Comparator<dgNinteiTaskList_Row> {
        private final RString colName;
        private final boolean isAsc;

        ShujiiIkenshoIraiTextBoxDateComparator(RString colName, boolean isAsc) {
            this.colName = colName;
            this.isAsc = isAsc;
        }

        @Override
        public int compare(dgNinteiTaskList_Row o1, dgNinteiTaskList_Row o2) {
            try {
                RStringBuilder methodName = new RStringBuilder();
                methodName.append(colName).replace(0, 1, methodName.substring(0, 1).toUpperCase()).insert(0, 取得メソッド);
                Method method = dgNinteiTaskList_Row.class.getMethod(methodName.toString());
                RDate d1 = RString.isNullOrEmpty(((TextBoxDate) (method.invoke(o1))).getText()) ? RDate.MIN : ((TextBoxDate) (method.invoke(o1))).getValue();
                RDate d2 = RString.isNullOrEmpty(((TextBoxDate) (method.invoke(o2))).getText()) ? RDate.MIN : ((TextBoxDate) (method.invoke(o2))).getValue();

                return isAsc ? d1.compareTo(d2) : d2.compareTo(d1);
            } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException ex) {
                return 0;
            }
        }
    }
}
