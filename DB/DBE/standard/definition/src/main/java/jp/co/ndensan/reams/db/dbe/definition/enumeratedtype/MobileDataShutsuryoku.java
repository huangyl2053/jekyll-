/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype;

/**
 * モバイルデータ出力を表す列挙型です。
 *
 * @author n8178 城間篤人
 */
public enum MobileDataShutsuryoku {

    /**
     * 出力済みであることを表します。
     */
    出力済(true),
    /**
     * まだ出力していないことを表します。
     */
    未出力(false);
    private final boolean is出力済;

    private MobileDataShutsuryoku(boolean is出力済) {
        this.is出力済 = is出力済;
    }

    /**
     * 出力済みであるか否かを、bool値で返します。
     *
     * @return 出力済みならtrue
     */
    public boolean is出力済() {
        return is出力済;
    }

    /**
     * 引数にbool値で出力済みか否かを指定することで_引数に対応したモバイルデータ出力の情報を返します。
     *
     * @param is出力済 出力済みならture
     * @return 引数に対応したモバイルデータ出力
     */
    public static MobileDataShutsuryoku toValue(boolean is出力済) {
        return is出力済 ? MobileDataShutsuryoku.出力済 : MobileDataShutsuryoku.未出力;
    }
}
