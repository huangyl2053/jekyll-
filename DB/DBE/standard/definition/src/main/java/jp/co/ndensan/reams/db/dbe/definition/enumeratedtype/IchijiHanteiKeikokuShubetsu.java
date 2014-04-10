/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;

/**
 * 制度改定ごとに一次判定警告の種類を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum IchijiHanteiKeikokuShubetsu {

    /**
     * 2006年度版の警告コードであることを表します。
     */
    介護保険制度2006年度版("K001", "2006", 62),
    /**
     * 2009年度版の警告コードであることを表します。
     */
    介護保険制度2009年度版("K002", "2009", 57);
    //TODO n8178 城間篤人 警告種別コードはコードマスタの種別コードに対応している。コードマスタの詳細が決まり次第、修正の可能性がある 2014年3月
    private final CodeShubetsu 警告種別コード;
    private final FlexibleYear 警告年度;
    private final int 警告数;

    private IchijiHanteiKeikokuShubetsu(String 警告種別コード, String 改定年度, int 警告数) {
        this.警告種別コード = new CodeShubetsu(警告種別コード);
        this.警告年度 = new FlexibleYear(改定年度);
        this.警告数 = 警告数;
    }

    /**
     * 警告種別コードを取得します。
     *
     * @return 警告種別コード
     */
    public CodeShubetsu get警告種別コード() {
        return 警告種別コード;
    }

    /**
     * 警告が何年度の制度に対応しているかを返します。
     *
     * @return 警告年度
     */
    public FlexibleYear get警告種別対応年度() {
        return 警告年度;
    }

    /**
     * 一次判定警告の数を返します。
     *
     * @return
     */
    public int get警告数() {
        return 警告数;
    }

    /**
     * 一次判定年月日を受け取り、それに対応した警告種別を返します。<br/>
     * 対応した警告種別が存在しない場合、例外が発生します。
     *
     * @param 一次判定年月日 一次判定年月日
     * @return 警告種別
     */
    public static IchijiHanteiKeikokuShubetsu toValue(FlexibleDate 一次判定年月日) {
        FlexibleYear 判定年度 = get判定年度(一次判定年月日);

        for (IchijiHanteiKeikokuShubetsu 警告種別 : values()) {
            if (警告種別.get警告種別対応年度().equals(判定年度)) {
                return 警告種別;
            }
        }
        throw new IllegalArgumentException(Messages.E00006.replace("対応する警告種別").getMessage());
    }

    private static FlexibleYear get判定年度(FlexibleDate 一次判定年月日) {
        List<FlexibleYear> 年度List = new ArrayList<>();
        for (IchijiHanteiKeikokuShubetsu 警告種別 : values()) {
            年度List.add(警告種別.get警告種別対応年度());
        }

        Collections.sort(年度List);
        Collections.reverse(年度List);

        for (FlexibleYear 年度 : 年度List) {
            if (年度.compareTo(一次判定年月日.getNendo()) <= 0) {
                return 年度;
            }
        }
        return null;
    }
}
