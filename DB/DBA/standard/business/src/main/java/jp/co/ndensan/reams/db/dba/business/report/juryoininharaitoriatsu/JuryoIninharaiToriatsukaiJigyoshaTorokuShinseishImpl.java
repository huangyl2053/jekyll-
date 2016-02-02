/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.juryoininharaitoriatsu;

import jp.co.ndensan.reams.db.dba.entity.report.juryoininharaitoriatsu.JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険受領委任払い取扱事業者登録申請書のBuilderクラスです
 */
public final class JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishImpl implements
        IJuryoIninharaiToriatsukaiJigyoshaTorokuShinseishBuilder {
    
    private final IJuryoIninharaiToriatsukaiJigyoshaTorokuShinseishEditor joho;
    
    /**
     * コンストラクタです。
     * @param joho 介護保険受領委任払い取扱事業者登録申請書のインターフェース
     */
    public JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishImpl(IJuryoIninharaiToriatsukaiJigyoshaTorokuShinseishEditor joho) {
        this.joho = joho;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JukiRendoTorokuListReportSource}
     */
    @Override
    public JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new JuryoIninharaiToriatsukaiJigyoshaTorokuShinseishoReportSource()).join(joho).buildSource();
    }
    
}
