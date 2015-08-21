/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.relate;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.enumeratedtype.YoKaigoJotaiKubun;
import jp.co.ndensan.reams.db.dbx.entity.relate.KaigohokenJukyushaAndKojinEntity;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険受給者DACのインターフェースです。
 *
 * @author N2806 太田 智之
 * @jpName 介護保険受給者Dacインタフェース
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護保険受給者
 * @mainClass
 * @reference
 */
public interface IKaigoHokenJukyushaDac {

    /**
     * 指定した対象者の介護受給者の情報を返します。
     *
     * @param 識別コード 識別コード
     * @return 検索結果
     */
    @Transaction
    List<KaigohokenJukyushaAndKojinEntity> select(RString 識別コード);

    /**
     * 指定した対象者の基準日時点での介護受給者の情報を返します。
     *
     * @param 識別コード 識別コード
     * @param 基準日 基準日
     * @return 検索結果
     */
    @Transaction
    KaigohokenJukyushaAndKojinEntity select(RString 識別コード, RDate 基準日);

    /**
     * 要介護状態区分範囲に一致する介護受給者の情報を返します。
     *
     * @param from要介護状態区分 from要介護状態区分
     * @param to要介護状態区分 from要介護状態区分
     * @param 基準日 基準日
     * @return 検索結果
     */
    @Transaction
    List<KaigohokenJukyushaAndKojinEntity> select(YoKaigoJotaiKubun from要介護状態区分, YoKaigoJotaiKubun to要介護状態区分, RDate 基準日);
}
