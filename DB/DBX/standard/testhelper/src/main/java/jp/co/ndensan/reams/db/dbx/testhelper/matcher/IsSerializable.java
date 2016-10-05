/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.testhelper.matcher;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Objects;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * シリアライズが可能かどうかをチェックする{@code Macther}です。
 */
public class IsSerializable extends BaseMatcher<Object> {

    private Result result;

    /** コンストラクタ */
    public IsSerializable() {
    }

    /**
     * {@link IsSerializable}を生成します。
     *
     * @return {@link IsSerializable}のインスタンス
     */
    public static Matcher<Object> serializable() {
        return new IsSerializable();
    }

    @Override
    public boolean matches(Object item) {
        if (!(item instanceof java.io.Serializable)) {
            return decideResult(Result.DoNotSerializable);
        }
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        try {
            ObjectOutputStream os = new ObjectOutputStream(bao);
            os.writeObject(item);
        } catch (IOException ex) {
            return decideResult(Result.CanNotSerialize);
        }
        Object deserialized;
        try {
            ByteArrayInputStream bai = new ByteArrayInputStream(bao.toByteArray());
            ObjectInputStream oi = new ObjectInputStream(bai);
            deserialized = oi.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            return decideResult(Result.CanNotDeserialize);
        }
        return decideResult(Objects.equals(item, deserialized) ? Result.Success : Result.NotEqual);
    }

    private boolean decideResult(Result t) {
        this.result = t;
        return result.isSuccess();
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("シリアライズした後、すぐにデシリアライズすると、シリアライズ前の状態が復元する ");
    }

    @Override
    public void describeMismatch(Object item, Description description) {
        description.appendText(result.errorMessage);
    }

    private enum Result {

        DoNotSerializable("java.io.Serializableを実装(implement)していません。"),
        CanNotSerialize("シリアライズできません。メンバが保持するインスタンス等、シリアライズ可能なオブジェクトが満たすべき条件について、実装を見直してください。"),
        CanNotDeserialize("デシリアライズに失敗しました。readObject()やreadResolve()の実装を見直してください。"),
        NotEqual("デシリアライズの結果がシリアライズ前と異なります。(equals()は正しくオーバライドはされていますか？されているなら、readObject()やreadResolve()の実装を見直してください。)"),
        Success("");
        //SUPPRESS CHECKSTYLE STRING-USE-CHECK//
        private final String errorMessage;

        private Result(String message) {
            this.errorMessage = message;
        }

        boolean isSuccess() {
            return this.equals(Success);
        }
    }
}
