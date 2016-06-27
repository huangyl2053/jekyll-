/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshojohoprint;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojohoprint.IkenshoJohoPrintMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojohoprint.IkenshoJohoPrintRelateEntity;

/**
 * 意見書情報印刷のマッパーインタフェースです。
 *
 * @reamsid_L DBE-1390-090 lijia
 *
 */
public interface IIkenshoJohoPrintMapper {

    /**
     * 主治医意見書依頼未処理者一覧情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 意見書情報印刷のMyBatis用パラメータ
     * @return List<KaigoJuminhyoRelateEntity>
     */
    List<IkenshoJohoPrintRelateEntity> get主治医意見書依頼未処理者情報(IkenshoJohoPrintMapperParameter mapperParameter);

    /**
     * 主治医意見書作成依頼変更者一覧情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 意見書情報印刷のMyBatis用パラメータ
     * @return List<KaigoJuminhyoRelateEntity>
     */
    List<IkenshoJohoPrintRelateEntity> get主治医意見書作成依頼変更者情報(IkenshoJohoPrintMapperParameter mapperParameter);

    /**
     * 主治医意見書作成依頼変更者一覧情報のデータの件数を取得します。
     *
     * @param mapperParameter 意見書情報印刷のMyBatis用パラメータ
     * @return count 件数
     */
    int get主治医意見書作成依頼変更者情報COUNT(IkenshoJohoPrintMapperParameter mapperParameter);

    /**
     * 主治医意見書未提出者一覧情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 意見書情報印刷のMyBatis用パラメータ
     * @return List<KaigoJuminhyoRelateEntity>
     */
    List<IkenshoJohoPrintRelateEntity> get主治医意見書未提出者情報(IkenshoJohoPrintMapperParameter mapperParameter);

    /**
     * 主治医意見書依頼済み一覧情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 意見書情報印刷のMyBatis用パラメータ
     * @return List<KaigoJuminhyoRelateEntity>
     */
    List<IkenshoJohoPrintRelateEntity> get主治医意見書依頼済み情報(IkenshoJohoPrintMapperParameter mapperParameter);

    /**
     * 主治医意見書５項目確認一覧情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 意見書情報印刷のMyBatis用パラメータ
     * @return List<KaigoJuminhyoRelateEntity>
     */
    List<IkenshoJohoPrintRelateEntity> get主治医意見書５項目確認情報(IkenshoJohoPrintMapperParameter mapperParameter);

    /**
     * 主治医意見書作成料請求一覧情報を条件指定検索で複数件取得します。
     *
     * @param mapperParameter 意見書情報印刷のMyBatis用パラメータ
     * @return List<KaigoJuminhyoRelateEntity>
     */
    List<IkenshoJohoPrintRelateEntity> get主治医意見書作成料請求情報(IkenshoJohoPrintMapperParameter mapperParameter);
}
