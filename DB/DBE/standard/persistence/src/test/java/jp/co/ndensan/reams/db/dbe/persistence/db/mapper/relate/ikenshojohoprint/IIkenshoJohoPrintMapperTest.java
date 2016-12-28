/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ikenshojohoprint;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.ikenshojohoprint.IkenshoJohoPrintMapperParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshojohoprint.IkenshoJohoPrintRelateEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link IIkenshoJohoPrintMapper}のテストクラス
 */
public class IIkenshoJohoPrintMapperTest extends DbeTestDacBase {

    private static IIkenshoJohoPrintMapper sut;

    @Before
    public void setUp() {
        sut = sqlSession.getMapper(IIkenshoJohoPrintMapper.class);
    }

    @Test
    public void get主治医意見書依頼未処理者情報_動作確認() {
        List<IkenshoJohoPrintRelateEntity> result = sut.get主治医意見書依頼未処理者情報(create意見書依頼未処理者情報検索条件());
        System.out.println("意見書依頼未処理者 件数：" + result.size());
        assertTrue(true);
    }

    @Test
    public void get主治医意見書作成依頼変更者情報_動作確認() {
        List<IkenshoJohoPrintRelateEntity> result = sut.get主治医意見書作成依頼変更者情報(create変更者情報検索条件());
        System.out.println("作成依頼変更者 件数：" + result.size());
        assertTrue(true);
    }

    @Test
    public void get主治医意見書作成料請求情報_動作確認() {
        List<IkenshoJohoPrintRelateEntity> result = sut.get主治医意見書作成料請求情報(create作成料請求検索条件());
        System.out.println("作成料請求 件数：" + result.size());
        assertTrue(true);
    }

    private IkenshoJohoPrintMapperParameter create意見書依頼未処理者情報検索条件() {
        RString 作成条件 = new RString("2");
        FlexibleDate 申請開始日 = new FlexibleDate(1999, 1, 1);
        FlexibleDate 申請終了日 = new FlexibleDate(2017, 12, 31);
        RString 通常コード = new RString(0);
        RString 延期コード = new RString(3);
        IkenshoJohoPrintMapperParameter param = IkenshoJohoPrintMapperParameter.createSelectByKeyParam(
                RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, RString.EMPTY, RString.EMPTY,
                作成条件, 申請開始日, 申請終了日,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                通常コード, 延期コード, FlexibleDate.EMPTY);
        return param;
    }

    private IkenshoJohoPrintMapperParameter create変更者情報検索条件() {
        FlexibleDate 申請開始日 = new FlexibleDate(2015, 1, 1);
        FlexibleDate 申請終了日 = new FlexibleDate(2016, 12, 31);
        RString 通常コード = new RString(0);
        RString 延期コード = new RString(3);
        IkenshoJohoPrintMapperParameter param = IkenshoJohoPrintMapperParameter.createSelectByKeyParam(
                RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                申請開始日,
                申請終了日,
                RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                通常コード, 延期コード, FlexibleDate.EMPTY);
        return param;
    }

    private IkenshoJohoPrintMapperParameter create作成料請求検索条件() {
        RString 作成条件 = new RString("1");
        RString 通常 = new RString("0");
        RString 延期 = new RString("3");
        FlexibleDate 処理日開始 = new FlexibleDate(2010, 10, 10);
        FlexibleDate 処理日終了 = new FlexibleDate(2010, 10, 10);
        FlexibleDate 受領日開始 = new FlexibleDate(2010, 10, 10);
        FlexibleDate 受領日終了 = new FlexibleDate(2010, 10, 10);
        IkenshoJohoPrintMapperParameter param = IkenshoJohoPrintMapperParameter.createSelectByKeyParam(
                RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, RString.EMPTY, RString.EMPTY, RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                FlexibleDate.EMPTY, FlexibleDate.EMPTY, RString.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY, FlexibleDate.EMPTY,
                作成条件, 処理日開始, 処理日終了, 受領日開始, 受領日終了, 通常, 延期, FlexibleDate.EMPTY);
        return param;
    }

}
